# coremedia-codechef

Who is our boss?

A comapany called CoreWave has a CEO Simon and a hierarchy of employees.
Employees can have a list of other employees reporting to them, which can themselves have reports, and so on.
An employee with at least one report is called a manager. 
 
Please, implement a method findClosestCommonManager to find the closest manager to two employees, who is farthest from the CEO Simon of CoreWave.
You can assume that all employees eventually report up to the CEO.
 
Example:
 
- CEO Simon has 3 employees, who report to him: {Kevin, Frank and Francine}
- Kevin has 3 reports: {Ulrike, Andy and Jan}
- Frank has no reports: {}
- Francine has no reports: {}
- Ulrike has 2 reports: {Milton, Nina}
- Andy has no reports: {}
- Jan has no reports: {}
- Milton has no reports: {} 
- Nina has no reports: {}
 
Example calls:
 
findClosestCommonManager(Milton, Nina): Ulrike

findClosestCommonManager(Nina, Jan): Kevin

findClosestCommonManager(Nina, Frank): Simon

findClosestCommonManager(Nina, Ulrike): Ulrike
