package com.noobForce.klasa.service;


import com.noobForce.klasa.model.Announcement;
import com.noobForce.klasa.model.Discussion;
import com.noobForce.klasa.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class AnnouncementService
{
    private final AnnouncementRepository announcementRepository;
    
    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository)
    {
        this.announcementRepository = announcementRepository;
    }
    
    public Announcement addAnnouncement(Announcement announcement)
    {
        return announcementRepository.save(announcement);
    }
    
    public void deleteAnnouncement()
    {
        announcementRepository.deleteAll();
    }
    
    public List<Announcement> getAllAnnouncements()
    {
        deleteAnnouncement();
        String[] profnames = new String[3];
        String[] announce = new String[15];
        LocalDate[] dates = new LocalDate[25];
        LocalTime[] times = new LocalTime[25];
        
        int[] d = new int[25];
        Random r = new Random();
        
        for (int i = 0; i < 25; i++)
            d[i] = Math.abs(r.nextInt() % 27) + 1;
        
        Arrays.sort(d);
//        Arrays.sort(d, Collections.reverseOrder());
        
        for (int i = 0; i < 25; i++) {
            dates[i] = LocalDate.of(2021, 6, d[i]);
            times[i] = LocalTime.of(Math.abs(r.nextInt() % 12) + 1, Math.abs(r.nextInt() % 60));
        }
        
        
        profnames[0] = "Shweta Sharma";
        profnames[1] = "Jayati Jain";
        profnames[2] = "Madhu Sharma";
        
        announce[0] = "Cancelled class tomorrow\n" +
                "Dear Students\n" +
                "We won’t be meeting tomorrow. The next class will be on June 17th.\n" +
                "Shweta";

        announce[1] = "There will be a quiz on Friday from 11-12. " +
                "This will be the first of the 3 quizzes which are supposed to be of 40% weightage.";//\n";

        announce[2] = "Dear Students\n" +
                "\n" +
                "Some students have changed their branch, so they moved from Section B to A, for such students, follow the same group no. in Section A as well";

        announce[3] = "Announcement: The extra credit policy (announced in class on June 4th) will also cover corrections of mistakes in lecture recordings. The date of the lecture and the minutes where the mistake is made should be emailed to me, or posted in Google Classroom.";

        announce[4] = "Hi everyone,\n" +
                "\n" +
                "This is to inform you that Lab 1 plag cases have been reported to the Academic Section and we are in the process of reporting Lab 2 plag cases now. Surprisingly, there are lot of students involved in plagiarism activities.";// +

        announce[5] = "For Students of SEC-A,\n" +
                "\n" +
                "\n" +
                "As per the poll conducted, we have decided to conduct weekly quiz on Monday 7 PM.\n" +
                "As due to time constraint we can not conduct the quiz tomorrow, so for this week quiz will be on Wednesday (23 June 2021).";// +

        announce[6] = "Section B, Group 2 students, the previous link isnt working so kindly join this link\n" +
                "https://meet.google.com/ptd-bzjo-skw\n" +
                "\n" +
                "(invite has been mailed to you)";

        announce[7] = "Just for clarification\n" +
                "\n" +
                "Only correct submissions will be counted in 5℅ bonus, for weekly LABs.";

        announce[8] = "Dear all,\n" +
                "\n" +
                "\n" +
                "Lab will be released in while and you will get sufficient for it. After that questions will be available in practice session.";

        announce[9] = "Hi everyone,\n" +
                "\n" +
                "There is a slight change in the Tutorial, Lab and one to one TA- student mapping. Please go through the sheets posted, before joining your respective groups.";

        announce[10] = "Hi all,\n" +
                "\n" +
                "\n" +
                "PFA the program which uses Reader class for Input. A sample program of Linear Search has been implemented.";// +

        announce[11] = "Lab 1 : Rubric\n" +
                "Theoretical calculation of Current (through RL & RAB), Thevenin's Voltage(VTH), Norton's current(IN), Thevenin’s Resistance(RTH) across AG and AB : 2 marks\n" +
                "TinkerCAD link (Thevenin's & Norton's) : 2 marks";/// +

        announce[12] = "Quiz_1_Update:\n" +
                "\n" +
                "Dear All,\n" +
                "\n" +
                "I hope you have received the calendar invite with Meet link for Quiz_1.";// +

        announce[13] = "Hello all, \n" +
                "You are supposed to upload the solutions of the tutorial sheet by the due date as mentioned in the classroom. We will post the solution after the due date.";

        announce[14] = "One hour was extended by one faculty member because a lot of her students were having uploading issues. I could not receive the decision in time, so could not extend your deadline in time.";
        
        int start = Math.abs(r.nextInt() % 15);
        for (int i = 0; i < 25; i++) {
            int x = Math.abs(r.nextInt() % 3);
            Announcement an = new Announcement(profnames[x], announce[(start++) % 15], dates[i], times[i]);
            addAnnouncement(an);
        }
        addAnnouncement(new Announcement(profnames[0], announce[2], LocalDate.of(2021, 6, 26), times[0]));
        addAnnouncement(new Announcement(profnames[1], announce[3], LocalDate.of(2021, 6, 27), times[1]));
        announce = null;
        dates = null;
        times = null;
        d = null;
        return announcementRepository.findAll();
    }
    
    public List<Announcement> getAllAnnouncementsByDate(int date)
    {
        getAllAnnouncements();
        return announcementRepository.findByDate(LocalDate.of(2021, 06, date));
    }

    //for search feature
    public List<Announcement> getByKeyword(String keyword) {return announcementRepository.findByKeyword(keyword);}
}
