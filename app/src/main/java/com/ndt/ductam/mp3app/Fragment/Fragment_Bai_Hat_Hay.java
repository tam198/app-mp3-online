package com.ndt.ductam.mp3app.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.ndt.ductam.mp3app.Adapter.BaihathayAdapter;
import com.ndt.ductam.mp3app.Model.Baihat;
import com.ndt.ductam.mp3app.R;
import com.ndt.ductam.mp3app.Service.APIservice;
import com.ndt.ductam.mp3app.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Bai_Hat_Hay extends Fragment {

    View view;
    //RecyclerView recyclerViewbaihathay;
    ListView listViewbaihathay;
    BaihathayAdapter baihathayAdapter;
    ArrayList<Baihat> baihatArrayList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bai_hat_hay, container, false);
        listViewbaihathay = view.findViewById(R.id.listviewbaihathay);
        //recyclerViewbaihathay = view.findViewById(R.id.recyclerviewbaihathay);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIservice.getService();
        Call<List<Baihat>> callback = dataservice.GetBaiHatHay();
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                baihatArrayList = (ArrayList<Baihat>) response.body();
                baihathayAdapter = new BaihathayAdapter(getActivity(), android.R.layout.simple_list_item_1, baihatArrayList);
                //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                //linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                //recyclerViewbaihathay.setLayoutManager(linearLayoutManager);
                //recyclerViewbaihathay.setAdapter(baihathayAdapter);
                listViewbaihathay.setAdapter(baihathayAdapter);
                setListViewHeightBasedOnChildren(listViewbaihathay);
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();

            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
