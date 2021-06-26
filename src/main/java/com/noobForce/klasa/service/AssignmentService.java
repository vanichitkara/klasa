package com.noobForce.klasa.service;

import java.time.LocalDate;
import java.util.List;

import com.noobForce.klasa.model.Discussion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noobForce.klasa.model.Assignment;
import com.noobForce.klasa.model.Resource;
import com.noobForce.klasa.repository.AssignmentRepository;


@Service
public class AssignmentService
{
	private final AssignmentRepository assignmentRepository;
	
	@Autowired
    public AssignmentService(AssignmentRepository assignmentRepository)
    {
        this.assignmentRepository = assignmentRepository;
    }
	
    public Assignment addAssignment(Assignment assignment)
    {
        return assignmentRepository.save(assignment);
    }
    
    public List<Assignment> getAllAssignments()
    {
        System.out.println("asses created");
    	deleteAssignment();
    	String[] Title = new String[15];
        LocalDate[] AssignedOn = new LocalDate[15];
        LocalDate[] DueOn = new LocalDate[15];
        int[] SNo = new int[15];
    	Boolean[] Status = new Boolean[15];
       
        Title[1] = "Assignment-1";
        Title[2] = "Lab-Assignment-5";
        Title[3] = "Quiz-4";
        Title[4] = "Test-1";
        Title[5] = "Assignment-5";
        Title[6] = "Lab-Assignment-3";
        Title[7] = "Quiz-6";
        Title[8] = "Test-2";
        Title[9] = "Assignment-7";
        Title[10] = "Lab-Assignment-8";
        Title[11] = "Quiz-7";
        Title[12] = "Test-3";
        Title[0] = "Assignment-9";
        Title[13] = "Lab-Assignment-4";
        Title[14] = "Quiz-9";
        
        for (int i = 0; i <3 ; i++)
        {
        	Status[i] = false;
        	
        }
        
        for (int i = 3; i <15 ; i++)
        {
        	Status[i] = true;
        	
        }
        
        for (int i = 0; i < 15; i++)
        {
        	SNo[i]= i + 1;
        }
        
        for (int i = 0; i < 15; i++)
        {
        	AssignedOn[i]= LocalDate.of(2021, 6, i+1);
        	DueOn[i]= LocalDate.of(2021, 6, i+15);
        }

        for(int i =0; i<30; i++)
        {
        	Assignment ass = new Assignment(i + 1, AssignedOn[i / 2], DueOn[i / 2], Status[i / 2], Title[i / 2]);
        	addAssignment(ass);
        }
        
        
        
        ////
        AssignedOn = null;
        DueOn = null;
        Title = null;
        return assignmentRepository.findAll();
    }
    
    public List<Assignment> getAllAssignmentsByDate(int dueDate)
    {
        getAllAssignments();
        return assignmentRepository.findByDueDate(LocalDate.of(2021, 06, dueDate));
    }
    public void deleteAssignment() {
        assignmentRepository.deleteAll();
    }

    //for search filter
    public List<Assignment> getByKeyword(String keyword) {return assignmentRepository.findByKeyword(keyword);}
}
