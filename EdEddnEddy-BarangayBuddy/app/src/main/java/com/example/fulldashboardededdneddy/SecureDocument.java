package com.example.fulldashboardededdneddy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fulldashboardededdneddy.R.id;
import com.example.fulldashboardededdneddy.R.layout;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

public final class SecureDocument extends AppCompatActivity {

    private Button residencyact;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_appointmentv2);
        Button barangayClearancbutton = (Button)this.findViewById(id.barangayClearancebtn);
        barangayClearancbutton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)SecureDocument.this, BarangayClearanceForm.class);
                SecureDocument.this.startActivity(intent);
            }
        }));
        Button businessclearancemainbutton = (Button)this.findViewById(id.businessclearancebtn);
        businessclearancemainbutton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)SecureDocument.this, BusinessClearanceMain.class);
                SecureDocument.this.startActivity(intent);
            }
        }));


        Button residencybtn = (Button)this.findViewById(id.residencybtnact);
        residencybtn.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)SecureDocument.this, residencyform.class);
                startActivity(intent);
            }
        }));

        /*
        Button indigencybtn = (Button)this.findViewById(id.indigencybtn);
        indigencybtn.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            @Override
            public final void onClick(View v) {
                Intent intent = new Intent((Context)SecureDocument.this, indigencyform.class);
                startActivity(intent);
            }
        })); */
    }
}
