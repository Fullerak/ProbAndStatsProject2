#https://www.sharetechnote.com/html/Octave_Matlab_csv.html#Write_Ex_01
#https://www.geeksforgeeks.org/octave-basics-of-plotting-data/
x=[-15:1:15];
y=x.^2+4
plot(x,y)
grid on
title('Plot')
xlabel('x')
ylabel('y')
csvwrite('Plotter.csv',[x;y]');
