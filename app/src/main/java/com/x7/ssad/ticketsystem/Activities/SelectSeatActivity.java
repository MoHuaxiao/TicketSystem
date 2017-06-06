package com.x7.ssad.ticketsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.x7.ssad.ticketsystem.R;
import com.x7.ssad.ticketsystem.SeatTable.SeatTable;
import com.x7.ssad.ticketsystem.Session.SessionManager;

import java.util.ArrayList;

public class SelectSeatActivity extends AppCompatActivity {
    private SeatTable seatTableView;
    private Button confirm_select_seat_btn;
    private SessionManager mSessionManager;
    private ArrayList<Pair<Integer, Integer>> selectSeats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_seat);

        initData();
        initViews();

//        TODOS：查询影厅数据库

        //设置屏幕名称（查询影厅数据库）
        seatTableView.setScreenName("8号厅荧幕");
        seatTableView.setMaxSelected(3);//设置最多选中

//        查询影厅数据库，知道哪些座位已选，每选择一个新的座位，将其记录到数组中，确定之后发送请求到后台
        seatTableView.setSeatChecker(new SeatTable.SeatChecker() {

            //            有getSelectedSeat方法
            @Override
            public boolean isValidSeat(int row, int column) {
//                设置哪些是合法的位置，比如这里，第五排就是过道，不能选
                if(column==5) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean isSold(int row, int column) {
                if(row==1&&column==1){
                    return true;
                }
                return false;
            }

            @Override
            public void checked(int row, int column) {
//                选中之后要做什么
//                Log.e("Jack", "checked " + row + " " + column);
                if (seatTableView.getSelectedSeat().size() > 0) {
                    confirm_select_seat_btn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void unCheck(int row, int column) {
//                反选之后要做什么
//                Log.e("Jack", "unchecked " + row + " " + column);
                if (seatTableView.getSelectedSeat().size() == 0) {
                    confirm_select_seat_btn.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public String[] checkedSeatTxt(int row, int column) {
                return null;
            }

        });
//        查询影厅数据库，获得影厅行列数
        seatTableView.setData(10,15);
//        button 点击事件，跳转到确认订单页面
        confirm_select_seat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 设置SessionManager，传入选中的座位
                mSessionManager.setSelectSeats(seatTableView.getSelectedSeat());
                Intent intent = new Intent(SelectSeatActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        seatTableView = (SeatTable) findViewById(R.id.seatView);
        confirm_select_seat_btn = (Button) findViewById(R.id.confirm_select_seat_btn);
    }

    private void initData() {
        mSessionManager = SessionManager.getInstance();
        selectSeats = new ArrayList<>();
    }

}
