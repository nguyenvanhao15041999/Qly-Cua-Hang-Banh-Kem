package com.example.projectchuyende;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projectchuyende.model.Dialog;
import com.example.projectchuyende.model.Nhan_Vien;
import com.example.projectchuyende.model.User;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public static Boolean isLogin = false;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private View headerView;
    private ImageView imgUserAva;
    private TextView tvEmpName;
    private TextView tvEmpJobTitle;
    private Menu menuNav;
    private MenuItem nav_signout, nav_signin;
    private  ListView lvDanhSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);


        headerView = navigationView.getHeaderView(0);
        imgUserAva = (ImageView) headerView.findViewById(R.id.imgUserAva);
        tvEmpName = (TextView) headerView.findViewById(R.id.tvEmpName);
        tvEmpJobTitle = (TextView) headerView.findViewById(R.id.tvEmpJobTitle);

        lvDanhSach = findViewById(R.id.lvDanhsachHome);

        menuNav = navigationView.getMenu();
        nav_signout = menuNav.findItem(R.id.nav_signout);
        nav_signout.setVisible(false);


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_trangchu, R.id.nav_thanhtoan, R.id.nav_trogiup)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);





    }




    @Override
    protected void onResume() {
        super.onResume();
        if (isLogin == true) {
            isLogin = false;
            if (getIntent().getSerializableExtra("nguoidung") != null) {
                User user = (User) getIntent().getSerializableExtra("nguoidung");
                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.nguoidung);

                // Menu item
                nav_signout = menuNav.findItem(R.id.nav_signout);
                nav_signout.setVisible(true);
                nav_signin = menuNav.findItem(R.id.nav_signin);
                nav_signin.setVisible(false);

                nav_signout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
//                        FirebaseAuth.getInstance().signOut();
//                        getIntent().putExtra("nguoidung", (String) null);
//                        finishAffinity();
                        dialog();
                        return false;
                    }
                });

                tvEmpName.setText(user.getUsername());
                if (user.getPermission().equals("user")) {
                    tvEmpJobTitle.setText("Khách Hàng");
                }
            } else if (getIntent().getSerializableExtra("nhanvien") != null) {
                isLogin = false;

                Nhan_Vien nhanvien = (Nhan_Vien) getIntent().getSerializableExtra("nhanvien");

                if (nhanvien.getChucvu().equals("Nhân Viên")) {
                    navigationView.getMenu().clear();
                    navigationView.inflateMenu(R.menu.nhanvien_menu);
                    // Menu item
                    nav_signout = menuNav.findItem(R.id.nav_signout);
                    nav_signout.setVisible(true);

                    nav_signin = menuNav.findItem(R.id.nav_signin);
                    nav_signin.setVisible(false);

                    nav_signout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            dialog();
                            return false;

                        }
                    });

                    tvEmpName.setText(nhanvien.getUser());
                    tvEmpJobTitle.setText(nhanvien.getChucvu());
                } else if (nhanvien.getChucvu().equals("Quản Lý")) {
                    navigationView.getMenu().clear();
                    navigationView.inflateMenu(R.menu.quanly_menu);
                    // Menu item
                    nav_signout = menuNav.findItem(R.id.nav_signout);
                    nav_signout.setVisible(true);

                    nav_signin = menuNav.findItem(R.id.nav_signin);
                    nav_signin.setVisible(false);

                    nav_signout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            dialog();
                            return false;
                        }
                    });

                    tvEmpName.setText(nhanvien.getUser());
                    tvEmpJobTitle.setText(nhanvien.getChucvu());
                }

            } else if (getIntent().getStringExtra("admin") != null) {
                String username = getIntent().getStringExtra("admin");

                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.admin_menu);
                // Menu item
                nav_signout = menuNav.findItem(R.id.nav_signout);
                nav_signout.setVisible(true);

                nav_signin = menuNav.findItem(R.id.nav_signin);
                nav_signin.setVisible(false);

                nav_signout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        dialog();
                        return false;
                    }
                });

                tvEmpName.setText(username);
                tvEmpJobTitle.setText("Admin");
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //thoat app
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.exit:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



    public void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Thông báo!");
        builder.setMessage("Bạn có muôn đăng xuất và thoát chương trình?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FirebaseAuth.getInstance().signOut();
                getIntent().putExtra("nguoidung", (String) null);
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }


}