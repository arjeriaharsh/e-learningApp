package com.harsharjeria.courseapp.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.harsharjeria.courseapp.Adapters.ClassesHomeList;
import com.harsharjeria.courseapp.Adapters.HotTopicsAdap;
import com.harsharjeria.courseapp.Adapters.WebsiteHomeList;
import com.harsharjeria.courseapp.Models.Users;
import com.harsharjeria.courseapp.R;
import com.harsharjeria.courseapp.Utils.Functions;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class fragment_home extends Fragment {

    private RecyclerView myRecyclerViewWebsites, myRecyclerViewWebsites2, yRecyclerViewHot;
    private Functions functions;
    private DocumentReference docRef;

    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth auth;

    private TextView nameTextView;
    private TextView test;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        functions = new Functions();
        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        docRef = firebaseFirestore.collection("users").document(Objects.requireNonNull(auth.getUid()));

        myRecyclerViewWebsites = v.findViewById(R.id.recyclerviewWebsites);
        yRecyclerViewHot = v.findViewById(R.id.recyclerviewTop);
        test = v.findViewById(R.id.imageView3);

        myRecyclerViewWebsites2 = v.findViewById(R.id.recyclerviewClasses);
        nameTextView = v.findViewById(R.id.textWelcomeName);
        nameTextView.setText("Welcome!\n");

        WebsiteHomeList websiteHomeList = new WebsiteHomeList(getContext(), functions.myWebsites());
        HotTopicsAdap hotTopicsAdap = new HotTopicsAdap(getContext(), functions.myClasses());
        ClassesHomeList classesHomeList = new ClassesHomeList(getContext(), functions.myClasses());

        myRecyclerViewWebsites.setHasFixedSize(true);
        myRecyclerViewWebsites.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false));
        myRecyclerViewWebsites.setAdapter(websiteHomeList);

        yRecyclerViewHot.setHasFixedSize(true);
        yRecyclerViewHot.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false));
        yRecyclerViewHot.setAdapter(hotTopicsAdap);

        myRecyclerViewWebsites2.setHasFixedSize(true);
        myRecyclerViewWebsites2.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false));
        myRecyclerViewWebsites2.setAdapter(classesHomeList);

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (Objects.requireNonNull(document).exists()) {
                        Users users = document.toObject(Users.class);
                        nameTextView.append(Objects.requireNonNull(users).getName());
                        if(users.permLevel == 1){
                            test.setText("Admin");
                            test.setTextColor(Color.RED);
                        }
                    } else {
                        Toast.makeText(getContext(), "Contact Us, Error!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Contact Us, Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}
