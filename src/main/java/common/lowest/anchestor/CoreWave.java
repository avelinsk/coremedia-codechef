package common.lowest.anchestor;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class CoreWave {

  public final Ceo simon = new Ceo("simon");
  public final Employee kevin = new Employee("kevin");
  public final Employee frank = new Employee("frank");
  public final Employee francine = new Employee("franchine");
  public final Employee ulrike = new Employee("ulrike");
  public final Employee andy = new Employee("andy");
  public final Employee jan = new Employee("jan");
  public final Employee milton = new Employee("milton");
  public final Employee nina = new Employee("nina");

  public CoreWave() {
    simon.addReportFrom(kevin);
    simon.addReportFrom(frank);
    simon.addReportFrom(francine);

    kevin.addReportFrom(ulrike);
    kevin.addReportFrom(andy);
    kevin.addReportFrom(jan);

    ulrike.addReportFrom(milton);
    ulrike.addReportFrom(nina);
  }

  public Employee findClosestCommonManager(Employee one, Employee two){
    out.println("Start : " + simon);
    out.println("Search: " + one);

    List<Employee> listOne = searchForEmployee(one);
    List<Employee> listTwo = searchForEmployee(two);

    Employee result = getParent(listOne, listTwo);
    out.println("---> RESULT " + result);
    return result;
  }

  private Employee getParent(List<Employee> listOne, List<Employee> listTwo) {
    Employee parentTwo = null;
    while (listOne.get(0).equals(listTwo.get(0))) {
      Employee parentOne = listOne.remove(0);
      parentTwo = listTwo.remove(0);

      if (listOne.isEmpty() && !listTwo.isEmpty()) {
        return parentOne;
      }
      if (!listOne.isEmpty() && listTwo.isEmpty()) {
        return parentTwo;
      }

    }
    return parentTwo;
  }

  private List<Employee> searchForEmployee(Employee employee) {
    List<Employee> list = new ArrayList<>();
    list.add(simon);
    list.addAll(getList(simon, employee));
    out.println(list);
    return list;
  }

  private List<Employee> getList(Employee startFromEmployee, Employee searchForEmployee) {
    List<Employee> result = new ArrayList<>();
    for(Employee employee : startFromEmployee.getReportsFrom()){
      List<Employee> list = new ArrayList<>();
      list.add(employee);
      if (employee.equals(searchForEmployee)) {
        return list;
      }
      List<Employee> children = getList(employee, searchForEmployee);
      if(!children.isEmpty() && children.get(children.size() - 1).equals(searchForEmployee)){
        list.addAll(children);
        return list;
      }
    }
    return result;
  }
}
