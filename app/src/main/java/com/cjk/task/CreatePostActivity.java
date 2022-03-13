package com.cjk.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.cjk.task.R.id.activityType;

public class CreatePostActivity extends AppCompatActivity implements BottomSheetDialog.ItemClickListener{
    Button selectSpinner;
    TextView  selectedText;
    EditText editText;
    ImageView music, video, image, addProfile, addImage, goBack;
    Button post;
    private static final int PICK_IMAGE = 100;
    private static final int PICK_VIDEO = 101;
    private static final int PICK_AUDIO = 102;
    Uri imageUri, videoUri, audioUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        goBack = findViewById(R.id.back);
        selectSpinner = findViewById(activityType);
        editText = findViewById(R.id.editTextTextMultiLine);
        music = findViewById(R.id.music2);
        video = findViewById(R.id.video2);
        image = findViewById(R.id.image2);
        addProfile = findViewById(R.id.add_profile);
        addImage = findViewById(R.id.add_picture);
        post = findViewById(R.id.postCreate);

        goBack.setOnClickListener(view -> {
            startActivity(new Intent(CreatePostActivity.this, MainActivity.class));
//            FragmentManager fm = getSupportFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//
//            FeedsFragment ff = new FeedsFragment();
//            ft.commit();
        });
        image.setOnClickListener(view -> {
            openGallery();
        });

        video.setOnClickListener(view -> {
            openVideo();
        });

        music.setOnClickListener(view -> {
            openAudio();
        });

        post.setOnClickListener(view -> {
            startActivity(new Intent(CreatePostActivity.this, MainActivity.class));
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            FeedsFragment ff = new FeedsFragment();

            ft.commit();
        });

        selectSpinner.setOnClickListener(view -> {
            BottomSheetDialog selectSpinner = BottomSheetDialog.newInstance();
            selectSpinner.show(getSupportFragmentManager(), BottomSheetDialog.TAG);
        });
    }

    private  void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    private  void openVideo(){
        //Intent gallery = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Video.Media.INTERNAL_CONTENT_URI);
        Intent gallery = new Intent();
        gallery.setType("video/*");
        gallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(gallery,"Select Video"),PICK_VIDEO);
        //startActivityForResult(gallery, PICK_VIDEO);
    }

    private  void openAudio(){
       // Intent gallery = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Audio.Media.INTERNAL_CONTENT_URI);
        Intent gallery = new Intent();
        gallery.setType("music/*");
        gallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(gallery,"Select Audio"),PICK_AUDIO);
       // startActivityForResult(gallery, PICK_AUDIO);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);;
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            image.setImageURI(imageUri);
            GridLayout params = new GridLayout(this);
            params.setAlignmentMode(GridLayout.ALIGN_BOUNDS);
            params.setColumnCount(2);
            params.setRowCount(3);

            params.setOrientation(GridLayout.HORIZONTAL);
            params.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            //ImageView Setup
            ImageView nImage = new ImageView(getApplicationContext());

            //setting image resource
            nImage.setImageURI(imageUri);
            //setting image position
            nImage.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            //adding view to layout
            params.addView(nImage);
            //make visible to program
            setContentView(params);

        }else if(resultCode == RESULT_OK && requestCode == PICK_VIDEO){
            videoUri = data.getData();
            video.setImageURI(videoUri);
        }else if(resultCode == RESULT_OK && requestCode == PICK_AUDIO){
            audioUri = data.getData();
            music.setImageURI(audioUri);
        }
    }


//    public void onPopupMenuClick(View view, int pos){
//
//        PopupMenu popup = new PopupMenu(this, view);
//        MenuInflater inflater =  popup.getMenuInflater();
//        inflater.inflate(R.menu.popup_menu, popup.getMenu());
//        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
//
//            @SuppressLint("NonConstantResourceId")
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                switch (menuItem.getItemId()){
//                    case R.id.edit: return true;
//                    case R.id.delete: return true;
//                    default: return false;
//                }
//            }
//        });
//        popup.show();
//    }

    public void onItemClick(String item){
        selectedText.setText(item.toString());
    }
}

