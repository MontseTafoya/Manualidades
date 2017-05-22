package com.example.monts.manualidades;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewPostFragment extends Fragment {
    ImageView ivPicture;
    Button btnTakePicture;
    String mCurrentPhotoPath;
    static final int REQUEST_IMAGE_CAPTURE=1;

    public NewPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_new_post, container, false);
        ivPicture=(ImageView) view.findViewById(R.id.ivPicture);
        btnTakePicture=(Button) view.findViewById(R.id.btnTakePicture);
        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode== REQUEST_IMAGE_CAPTURE && resultCode==getActivity().RESULT_OK){
            Bundle extras=data.getExtras();
            Bitmap imageBitmap= (Bitmap) extras.get("data");
            ivPicture.setImageBitmap(imageBitmap);
        }
    }

    private void takePicture() {

        Intent takePictureIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getActivity().getPackageManager())!= null ){

            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);


        }
    }



}
