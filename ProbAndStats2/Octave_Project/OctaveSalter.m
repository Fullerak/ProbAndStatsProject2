#used teh same way i did in the java csv
data = csvread('Plotter.csv')
x = data(:,1)
y = data(:,2)
for i=1:31
   y(i) = y(i) + randi([-30,30])
 end

 #plotting
 plot(x,y)
 grid on
 title('Salter')

 #reshape + writing to csv
r = reshape([x;y],31,2)
csvwrite('Salter.csv',r)
