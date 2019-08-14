package com.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Dao.studentDao;
import com.nimbusds.oauth2.sdk.Request;
import com.Bean.ExamBean;
import com.Bean.QuestionBean;
import com.Bean.StudentExamBean;
import com.Bean.studentBean;

@Controller
public class studentController {

	@Autowired
	studentDao studentdao;

	@RequestMapping(value = "/Studentvalidation")
	public String loadstudentvalidation() {

		return "Studentvalidation";
	}

	@RequestMapping(value = "/Student")
	public String loadregister() {

		return "Studentvalidation";
	}

	@RequestMapping(value = "/Student", method = RequestMethod.GET)
	public String loadstudent() {

		return "Student";
	}

	@RequestMapping(value = "/studentinfo", method = RequestMethod.POST)
	public String insertstudentinfo(studentBean studentbean) {
		studentdao.insert(studentbean);
		return "Studentvalidation";
	}

	@RequestMapping(value = "/validation", method = RequestMethod.POST)
	public String showdata(studentBean studentBean, HttpServletRequest request) {

		String username = studentBean.getUsername();
		String password = studentBean.getPassword();

		
		List<studentBean> b = studentdao.datavalidation(username, password);
if(!b.isEmpty())
{

	request.getSession().setAttribute("studentid", b.get(0).getStudentid());
	return "redirect:/Exam";	
}
		
		
	return "Student";
	}

	@RequestMapping(value = "/Exam", method = RequestMethod.GET)
	public String showdata(ExamBean examBean, Model model) {
		List<ExamBean> list = studentdao.examlist();
		model.addAttribute("exam", list);

		return "Exam";
	}

	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public String getdatabyId(ExamBean examBean, Model model) {
		List<ExamBean> list = studentdao.getAlldata(examBean);
		int id = list.get(0).getExamid();
		List<QuestionBean> list1 = studentdao.getAlldataofQuestion(id);
		model.addAttribute("exam", list.get(0));
		model.addAttribute("question", list1);

		return "question";

	}

	@RequestMapping(value = "/examscore", method = RequestMethod.GET)
	public String score(HttpServletRequest request,StudentExamBean studentxambean)
	{
		int marks=0;
		int que[]=new int[3];
		for(int i=0;i<3;i++)
		{
			int j=i+1;
			que[i]=Integer.parseInt(request.getParameter("questionid"+j));
		
		}

		String ans[]=new String[3];
		for(int i=0;i<ans.length;i++)
		{
			int j=i+1;
			ans[i]=request.getParameter("option"+j);
			System.out.println("ans[i] = "+ans[i]);
		}
		System.out.println("ccccccc");
		int examid=Integer.parseInt(request.getParameter("examid"));
		System.out.println("id:- "+examid);
		List<QuestionBean> list=studentdao.questioncheck(examid);
	
 		for (int i = 0; i <list.size(); i++) {
 			{

 				String temp="temp"+i;
 				System.out.println("temp"+temp);
 				System.out.println("list.get(i).getAnswer() "+list.get(i).getAnswer());
 				if(list.get(i).getAnswer().equals(ans[i]))
 				{
 					marks++;
 				}
 				System.out.println(marks);
 			}

 			String status="";

 			if(marks>=list.size()/2)
 			{
 				System.out.println("PASS");
 				status="Pass";
 			}
 			else
 			{
 				System.out.println("FAIL");
 				status="Fail";
 			}
 			System.out.println("Status:-"+status);
 		
 		
 			int studentid=Integer.parseInt(request.getSession().getAttribute("studentid").toString());
 			System.out.println("StudentId:-"+studentid);
        
 			for(int j=0;j<ans.length;j++)
 			{
 		        studentxambean.setStudentexamid(examid);
 		       studentxambean.setAnswer(ans[j]);
 		      studentxambean.setStatus(status);
 		     studentxambean.setQuestionid(que[i]);
 		    studentxambean.setStudentid(studentid);
 		   studentxambean.setExamid(examid);
 		   studentdao.insertexam(studentxambean);
 			}
 			
 		}

		return "redirect:result";
}
}