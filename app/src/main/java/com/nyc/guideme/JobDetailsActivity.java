package com.nyc.guideme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.nyc.guideme.models.JobModels;

public class JobDetailsActivity extends AppCompatActivity {

    private JobModels job;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);

        Intent intent = getIntent();
        if(intent.hasExtra("jobDetails")) {
            job = new Gson().fromJson(intent.getStringExtra("jobDetails"),JobModels.class);
        }


        /**
         * "__of_positions": "1",
         --"additional_information": "**IMPORTANT NOTES TO ALL CANDIDATES:  Please note:  If you are called for an interview you will be required to bring to your interview copies of original documentation, such as: â€¢ A document that establishes identity for employment eligibility, such as: A Valid U.S. Passport, Permanent Resident Card/Green Card, or Driverâ€™s license.    â€¢ Proof of Education according to the education requirements of the civil service title.    â€¢ Current Resume     â€¢ Proof of Address/NYC Residency dated within the last 60 days, such as: Recent Utility Bill (i.e. Telephone, Cable, Mobile Phone)   Additional documentation may be required to evaluate your qualification as outlined in this postingâ€™s â€œMinimum Qualification Requirementsâ€ section. Examples of additional documentation may be, but not limited to: college transcript, experience verification or professional trade licenses.  If after your interview you are the selected candidate you will be contacted to schedule an on-boarding appointment.   By the time of this appointment you will be asked to produce the originals of the above documents along with your original Social Security card.   **LOAN FORGIVENESS  The federal government provides student loan forgiveness through its Public Service Loan Forgiveness Program (PSLF) to all qualifying public service employees. Working with the DOHMH qualifies you as a public service employee and you may be able to take advantage of this program while working full-time and meeting the programâ€™s other requirements.    Please visit the Public Service Loan Forgiveness Program site to view the eligibility requirements:   https://studentaid.ed.gov/sa/repay-loans/forgiveness-cancellation/public-service",
         --"agency": "DEPT OF HEALTH/MENTAL HYGIENE",
         --"business_title": "Application Examiner, Bureau of Vital Statistics/Vital Statistics/Vital Records",
         --"civil_service_title": "CLERICAL ASSOCIATE",
         --"division_work_unit": "Vital Statistics/Vital Recor",
         --"full_time_part_time_indicator": "F",
         "hours_shift": " ",
         --"job_category": "Health",
         --"job_description": "**OPEN TO PERMANENT CLERICAL ASSOCIATES ONLY. YOU MUST CLEARLY STATE YOUR CIVIL SERVICE STATUS ON YOUR RESUME OR COVER LETTER. FAILURE TO DO SO WILL RESULT IN YOUR DISQUALIFICATION.   The NYC Department of Health and Mental Hygiene (DOHMH) is an agency recognized worldwide for being a leader in public health.  The Bureau of Vital Statistics is responsible for registering and certifying all birth, deaths, spontaneous and induced terminations of pregnancy in NYC.  The bureau issues, analyzes and reports on 285,000 vital events each year.  The bureau is a very large customer service operation, providing death certification services on a 24/7 basis, issuing more than 900,000 certified copies of birth and death records, and fulfilling hundreds of data requests annually.   DUTIES WILL INCLUDE BUT NOT BE LIMITED TO:   - Receive and accurately examine physical and/or electronic birth and or death correction applications and supporting documents, including, Acknowledgement of Paternity, Court Ordered Filiations, Adoption Orders and Transgender amendments; ensuring documentary evidence, identification and fee(s) are appropriately submitted. Review confidential documents submitted with application for completeness.   - Accurately complete or reject amendments according to DOHMH, Vital Records guidelines.   - Adhere to established turn-around times for accurately processing applications.   - Respond to telephone and written inquiries from customers, including other City, State and Federal agencies.   - Deliver excellent customer service when resolving and addressing customer inquiries, including with in-person customers, via email and phone.   - Perform other related clerical support functions, including assisting with special projects, testing new workflow processes, faxing, filing and indexing. Transfer cases to and from other Office of Vital Records Units as needed.",
         --"job_id": "319057",
         "level": "3",
         --"minimum_qual_requirements": "Qualification Requirements  A four-year high school diploma or its educational equivalent approved by a State's department of education or a recognized accrediting organization and one year of satisfactory clerical experience.  Skills Requirement  Keyboard familiarity with the ability to type at a minimum of 100 key strokes (20 words) per minute.",
         --"post_until": "2018-05-11T00:00:00",
         --"posting_date": "2018-01-16T00:00:00",
         "posting_type": "External",
         "posting_updated": "2018-01-16T00:00:00",
         --"preferred_skills": "Must be comfortable working in a dynamic atmosphere handling multiple concurrent activities displaying excellent attention to detail; work well with a team to meet deadlines and analyze problems and potentially difficult scenarios. Knowledge of detailed record keeping systems; excellent oral, written, administrative and customer service skills. Strong working knowledge of Microsoft Office Programs such as Word, Excel and Access. Ability to speak Spanish or a language other than English is a plus.",
         "process_date": "2018-02-27T00:00:00",
         --"residency_requirement": "New York City residency is generally required within 90 days of appointment. However, City Employees in certain titles who have worked for the City for 2 continuous years may also be eligible to reside in Nassau, Suffolk, Putnam, Westchester, Rockland, or Orange County. To determine if the residency requirement applies to you, please discuss with the agency representative at the time of interview.",
         --"salary_frequency": "Annual",
         --"salary_range_from": "33875",
         --"salary_range_to": "42072.48",
         "title_code_no": "10251",
         "to_apply": "Apply online with a cover letter to https://a127-jobs.nyc.gov/  In the Job ID search bar, enter: job ID number #   We appreciate the interest and thank all applicants who apply, but only those candidates under consideration will be contacted.  The NYC Health Department is committed to recruiting and retaining a diverse and culturally responsive workforce. We strongly encourage people of color, people with disabilities, veterans, women, and lesbian, gay, bisexual, and transgender and gender non-conforming persons to apply.  All applicants will be considered without regard to actual or perceived race, color, national origin, religion, sexual orientation, marital or parental status, disability, sex, gender identity or expression, age, prior record of arrest; or any other basis prohibited by law.",
         --"work_location": "125 Worth Street, Nyc",
         "work_location_1": " "
         */
    }
}
