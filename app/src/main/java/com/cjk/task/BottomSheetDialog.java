package com.cjk.task;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog extends BottomSheetDialogFragment implements View.OnClickListener{

    public static  final String TAG = "BottomSheetDialog";
    private ItemClickListener listener;

    public BottomSheetDialog(){}

    public static BottomSheetDialog newInstance() {
        return new BottomSheetDialog();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState) {

        return inflater.inflate(R.layout.bottom_sheet, container, false);

    }

    public void onViewCreated(@NonNull View v, Bundle SavedInstanceState){
        super.onViewCreated(v,SavedInstanceState);
        v.findViewById(R.id.cultural).setOnClickListener(this);
        v.findViewById(R.id.sport).setOnClickListener(this);
        v.findViewById(R.id.event).setOnClickListener(this);
        v.findViewById(R.id.academics).setOnClickListener(this);
    }

    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        if(context instanceof ItemClickListener){
            listener = (ItemClickListener) context;
        }else{
            throw new RuntimeException(context.toString() + "must implement ItemClickListener");
        }
    }
    public void onDetach(){
        super.onDetach();
        listener = null;
    }

    @Override
    public void onClick(View view) {
        TextView selectedText = (TextView) view;
        listener.onItemClick(selectedText.getText().toString());
        dismiss();
    }

    public interface ItemClickListener{
        void onItemClick(String item);
    }
}
