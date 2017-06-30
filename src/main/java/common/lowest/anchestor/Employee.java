package main.java.common.lowest.anchestor;

/**
 * Created by emueller on 30.06.17.
 */
import java.util.HashSet;
import java.util.Set;

public class Employee {

  private final String name;
  private final Set<Employee> reportsFrom;

  Employee(String name) {
    this.name = name;
    this.reportsFrom = new HashSet<>();
  }

  void addReportFrom(Employee employee){
    this.reportsFrom.add(employee);
  }

  Set<Employee> getReportsFrom() {
    return reportsFrom;
  }

  @Override
  public String toString() {
    return name;
  }
}
