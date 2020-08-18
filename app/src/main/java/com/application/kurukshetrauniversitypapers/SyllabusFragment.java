package com.application.kurukshetrauniversitypapers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapters.SyllabusAdapter;
import Adapters.SyllabusAdapter;

public class SyllabusFragment extends Fragment {
    Button cse_syl,it_syl,me_syl,ee_syl,ec_syl,mb_syl,bb_syl,bc_syl,mc_syl,first_syl,second_syl,third_syl,fourth_syl,fifth_syl,sixth_syl,seventh_syl,eight_syl,session;
    String selected_branch_syllabus,selected_semester_syllabus;
    DatabaseReference databaseReference;
    ArrayList<String> subjects;
    List<uploadPDF> uploadPDFS;
    ListView listView;
    Button search_syl;
    
    public SyllabusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_syllabus, container, false);
        cse_syl=v.findViewById(R.id.cse_syl);
        it_syl=v.findViewById(R.id.it_syl);
        me_syl=v.findViewById(R.id.me_syl);
        ee_syl=v.findViewById(R.id.ee_syl);
        ec_syl=v.findViewById(R.id.ec_syl);
        bb_syl=v.findViewById(R.id.bb_syl);
        mb_syl=v.findViewById(R.id.mb_syl);
        bc_syl=v.findViewById(R.id.bc_syl);
        mc_syl=v.findViewById(R.id.mc_syl);
        first_syl=v.findViewById(R.id.first_syl);
        second_syl=v.findViewById(R.id.second_syl);
        third_syl=v.findViewById(R.id.third_syl);
        fourth_syl=v.findViewById(R.id.fourth_syl);
        fifth_syl=v.findViewById(R.id.fifth_syl);
        sixth_syl=v.findViewById(R.id.sixth_syl);
        seventh_syl=v.findViewById(R.id.seventh_syl);
        eight_syl=v.findViewById(R.id.eight_syl);
        uploadPDFS= new ArrayList<>();
        subjects=new ArrayList<>();
        listView=v.findViewById(R.id.list_syllabus);
        search_syl=v.findViewById(R.id.sy_search);
        session=v.findViewById(R.id.session_20_21);

       displayDefaultResults();
        cse_syl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected_branch_syllabus="CS";

                cse_syl.setBackgroundResource(R.drawable.button_pressed);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(true);
                fourth_syl.setEnabled(true);
                fifth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(true);
                eight_syl.setEnabled(true);

            }
        });
        it_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch_syllabus="IT";

                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_pressed);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(true);
                fifth_syl.setEnabled(true);
                fourth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(true);
                eight_syl.setEnabled(true);
            }
        });
        me_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch_syllabus="ME";

                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_pressed);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(true);
                fifth_syl.setEnabled(true);
                fourth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(true);
                eight_syl.setEnabled(true);
            }
        });
        ec_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch_syllabus="EC";

                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_pressed);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(true);
                fifth_syl.setEnabled(true);
                fourth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(true);
                eight_syl.setEnabled(true);
            }
        });
        ee_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch_syllabus="EL";

                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_pressed);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(false);
                fifth_syl.setEnabled(false);
                fourth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(true);
                eight_syl.setEnabled(true);
            }
        });
        mb_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch_syllabus="MB";
                //setList();
                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_pressed);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(false);
                fourth_syl.setEnabled(false);
                fifth_syl.setEnabled(false);
                sixth_syl.setEnabled(false);
                seventh_syl.setEnabled(false);
                eight_syl.setEnabled(false);
                Log.e("branch",selected_branch_syllabus);
            }
        });
        bb_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch_syllabus="BB";

                //setList();
                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_pressed);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(true);
                fourth_syl.setEnabled(true);
                fifth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(false);
                eight_syl.setEnabled(false);
                Log.e("branch",selected_branch_syllabus);
            }
        });
        bc_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch_syllabus="BC";

                //setList();
                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_pressed);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(true);
                fourth_syl.setEnabled(true);
                fifth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(false);
                eight_syl.setEnabled(false);
                Log.e("branch",selected_branch_syllabus);
            }
        });
        mc_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch_syllabus="MC";

                //setList();
                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_pressed);
                third_syl.setEnabled(false);
                fourth_syl.setEnabled(false);
                fifth_syl.setEnabled(false);
                sixth_syl.setEnabled(false);
                seventh_syl.setEnabled(false);
                eight_syl.setEnabled(false);
                Log.e("branch",selected_branch_syllabus);
            }
        });

        first_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus = "01";

                first_syl.setBackgroundResource(R.drawable.button_pressed);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_default);
            }
        });
        second_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="02";

                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_pressed);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_default);
            }
        });
        third_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="03";

                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_pressed);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_default);
            }
        });
        fourth_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="04";

                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_pressed);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_default);

            }
        });
        fifth_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="05";

                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_pressed);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_default);
            }
        });
        sixth_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="06";

                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_pressed);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_default);
            }
        });
        seventh_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="07";

                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_pressed);
                eight_syl.setBackgroundResource(R.drawable.button_default);

            }
        });
        eight_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="08";

                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_pressed);
            }
        });

        search_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
                singleDownloadClass.setBranch(selected_branch_syllabus);
                singleDownloadClass.setSemester(selected_semester_syllabus);
                databaseReference = FirebaseDatabase.getInstance().getReference("IN/KU/" + selected_branch_syllabus + "/" + selected_semester_syllabus + "/" + "Syllabus");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        uploadPDFS.clear();
                        for (DataSnapshot pdfSnapshot : dataSnapshot.getChildren()) {
                            uploadPDF uploadPDF = pdfSnapshot.getValue(uploadPDF.class);
                            uploadPDFS.add(uploadPDF);
                        }
                        SyllabusAdapter adapter = new SyllabusAdapter(getActivity(), uploadPDFS);
                        listView.setAdapter(adapter);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        
        return v;
    }


    
//    public void displayResults()
//    {
//        SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
//        singleDownloadClass.setBranch(selected_branch_syllabus);
//        singleDownloadClass.setSemester(selected_semester);
//        databaseReference = FirebaseDatabase.getInstance().getReference("IN/KU/" + selected_branch_syllabus + "/" + selected_semester + "/" + "Syllabus");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                uploadPDFS.clear();
//                for (DataSnapshot pdfSnapshot : dataSnapshot.getChildren()) {
//                    uploadPDF uploadPDF = pdfSnapshot.getValue(uploadPDF.class);
//                    uploadPDFS.add(uploadPDF);
//                }
//
//                SyllabusAdapter adapter = new SyllabusAdapter(getActivity(), uploadPDFS);
//                listView.setAdapter(adapter);
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
    public void displayDefaultResults()
    {
        selected_branch_syllabus="CS";
        selected_semester_syllabus="01";
        cse_syl.setBackgroundResource(R.drawable.button_pressed);
        first_syl.setBackgroundResource(R.drawable.button_pressed);
        session.setBackgroundResource(R.drawable.button_pressed);

//        SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
//        singleDownloadClass.setBranch(selected_branch_syllabus);
//        singleDownloadClass.setSemester(selected_semester);
//        databaseReference = FirebaseDatabase.getInstance().getReference("IN/KU/" + selected_branch_syllabus + "/" + selected_semester + "/" + "Syllabus");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                uploadPDFS.clear();
//                for (DataSnapshot pdfSnapshot : dataSnapshot.getChildren()) {
//                    uploadPDF uploadPDF = pdfSnapshot.getValue(uploadPDF.class);
//                    uploadPDFS.add(uploadPDF);
//                }
//
//                SyllabusAdapter adapter = new SyllabusAdapter(getActivity(), uploadPDFS);
//                listView.setAdapter(adapter);
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }
}