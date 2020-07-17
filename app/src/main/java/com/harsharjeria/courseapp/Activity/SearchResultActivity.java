package com.harsharjeria.courseapp.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import maes.tech.intentanim.CustomIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.harsharjeria.courseapp.Fragments.fragment_search;
import com.harsharjeria.courseapp.Models.Course;
import com.harsharjeria.courseapp.R;
import com.harsharjeria.courseapp.Utils.Functions;
import com.squareup.picasso.Picasso;

public class SearchResultActivity extends AppCompatActivity {

    private RecyclerView mRecyclerQueryView2;
    private FirestoreRecyclerAdapter<Course, ProductViewHolder> adapter;
    private Functions functions;
    private ProgressBar progress_circular;

    private int websiteID;

    private static String intValue = "websiteId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        functions = new Functions();
        mRecyclerQueryView2 = findViewById(R.id.recyclerViewQuery2);
        mRecyclerQueryView2.setLayoutManager(new LinearLayoutManager(this));
        if(getIntent().hasExtra(intValue)){
            websiteID = getIntent().getIntExtra(intValue, 0);
        }
        progress_circular = findViewById(R.id.progress_circular);

        setTitle(functions.myWebsites()[websiteID].websiteName);

        launch();

    }


    private class ProductViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView textServiceName;
        private TextView textServicePrice;
        private TextView textServiceType;
        private ImageView imageView;

        ProductViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textServiceName = view.findViewById(R.id.name);
            textServicePrice = view.findViewById(R.id.website);
            textServiceType = view.findViewById(R.id.textView3);
            imageView = view.findViewById(R.id.logoIcon);
        }

        void setProductName(String productName) {
            textServiceName.setText(productName);
        }
    }

    private void launch(){
        if(adapter != null){
            adapter.stopListening();
        }

        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();

        final CollectionReference citiesRef = rootRef.collection("courses");
        Query query = citiesRef.whereEqualTo("website", websiteID).orderBy("namecourse");

        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (queryDocumentSnapshots != null && !queryDocumentSnapshots.isEmpty()){
                    progress_circular.setVisibility(View.INVISIBLE);
                }else if (queryDocumentSnapshots != null && queryDocumentSnapshots.isEmpty()){
                    Toast.makeText(SearchResultActivity.this, "This service block is empty.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SearchResultActivity.this, "Error, please contact on email.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        FirestoreRecyclerOptions<Course> options = new FirestoreRecyclerOptions.Builder<Course>()
                .setQuery(query, Course.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<Course, ProductViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull final Course model) {
                holder.setProductName(model.getNamecourse());
                holder.textServicePrice.setText(functions.myWebsites()[model.website].websiteName + " - "+ model.getRatings() + "★");
                holder.textServiceType.setText(model.getPriceAmount() + "");

                Picasso.get().load(functions.myWebsites()[model.website].websiteIconLink).into(holder.imageView);
            }

            @NonNull
            @Override
            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_courses, parent, false);
                return new ProductViewHolder(view);
            }
        };
        mRecyclerQueryView2.setAdapter(adapter);
        adapter.startListening();

    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter != null) {
            adapter.startListening();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (adapter != null) {
            adapter.stopListening();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (adapter != null) {
            adapter.stopListening();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this, "right-to-left");
    }
}
