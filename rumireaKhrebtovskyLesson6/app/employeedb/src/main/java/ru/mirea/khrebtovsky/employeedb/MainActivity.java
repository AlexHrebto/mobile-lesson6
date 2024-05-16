package ru.mirea.khrebtovsky.employeedb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AppDatabase db = App.getInstance().getDatabase();

        EmployeeDao employeeDao = db.employeeDao();

        Employee employee0 = new Employee();
        employee0.id = 1;
        employee0.name = "John Smith";
        employee0.salary = 20000;
        employeeDao.insert(employee0);

        Employee employee1 = new Employee();
        employee1.id = 2;
        employee1.name = "John Smith";
        employee1.salary = 10000;
        employeeDao.insert(employee1);

        Employee employee2 = new Employee();
        employee2.id = 3;
        employee2.name = "Jane Doe";
        employee2.salary = 12000;
        employeeDao.insert(employee2);

        Employee employee3 = new Employee();
        employee3.id = 4;
        employee3.name = "Michael Johnson";
        employee3.salary = 15000;
        employeeDao.insert(employee3);

        List<Employee> employees = employeeDao.getAll();

        for (Employee employee : employees) {
            Log.d(TAG, "Name: " + employee.name + ", Salary: " + employee.salary);
        }
    }
}
