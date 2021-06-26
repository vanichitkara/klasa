package com.noobForce.klasa.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import com.noobForce.klasa.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.noobForce.klasa.model.Resource;
import com.noobForce.klasa.repository.ResourceRepository;

@Service
public class ResourceService 
{
	private final ResourceRepository resourceRepository;
	
	
	@Autowired
    public ResourceService(ResourceRepository resourceRepository)
    {
        this.resourceRepository = resourceRepository;
    }
    
    public Resource addResource(Resource resource)
    {
        return resourceRepository.save(resource);
    }
    

      public List<Resource> getAllResourcesByDate(int date)
    {
        getAllResources();
        return resourceRepository.findByDate(LocalDate.of(2021, 06, date));
    }
    
    public void deleteResource() {
        resourceRepository.deleteAll();
    }
    
    public List<Resource> getAllResources()
    {
        deleteResource();
        System.out.println("getallresources called");
        deleteResource();
        String[] link = new String[3];
        String[] resource = new String[15];
        LocalDate[] dates = new LocalDate[15];
        LocalTime[] times = new LocalTime[15];
        int[] SNo = new int[15];
        
        Random r = new Random();
        
        for (int i = 0; i < 15; i++)
        {
            times[i] = LocalTime.of(Math.abs(r.nextInt() % 24), Math.abs(r.nextInt() % 60));
        }
        

        for (int i = 0; i < 15; i++)
        {
        	SNo[i]= i + 1;
        }
        
        for (int i = 0; i < 15; i++)
        {
        	dates[i]= LocalDate.of(2021, 6, i+15);
        	
        }        
        
        resource[1] = "PDF of L-2(Unit-4)";
        resource[2] = "PDF of L-1(Unit-4)";
        resource[3] = "PDF of L-2(Unit-3)";
        resource[4] = "PDF of L-1(Unit-3)";
        resource[5] = "PDF of L-3(Unit-3)";
        resource[6] = "PDF of L-7(Unit-5)";
        resource[7] = "PDF of L-12(Unit-8)";
        resource[8] = "PDF of L-8(Unit-7)";
        resource[9] = "PDF of L-5(Unit-10)";
        resource[10] = "PDF of L-1(Unit-6)";
        resource[11] = "PDF of L-7(Unit-8)";
        resource[12] = "PDF of L-2(Unit-10)";
        resource[13] = "PDF of L-6(Unit-4)";
        resource[14] = "PDF of L-13(Unit-4)";
        resource[0] = "PDF of L-6(Unit-9)";
        
        
        link [1] = "https://www.sciencelearn.org.nz/resources/";
        link [2] = "https://bygus.com/physics/";
        link [0] = "https://en.wikpedia.org/wiki/";
        
        for(int i =0; i<30; i++)
        {
        	Resource Re = new Resource(i + 1, link[i % 3], resource[i / 2], dates[i / 2], times[i / 2]);
        	addResource(Re);
            System.out.println(Re);
        }
        
        resource = null;
        link = null;
        times = null;
        dates = null;
        return resourceRepository.findAll();
    }

    //for search filter
    public List<Resource> getByKeyword(String keyword) {return resourceRepository.findByKeyword(keyword);}
	
}
