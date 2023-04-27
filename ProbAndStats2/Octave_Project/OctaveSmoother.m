#boiler plate code to get the graph going
data = csvread('Salter.csv')
x = data(:,1)
y = data(:,2)
newY = y;
value = 1;
repeat = 10;
temp = 0;
count = 0;

#same way as i did in java
for i=1:repeat
  for j=1:31
    for k= j-value:j+value
      if(k > 0 && k < 32)
      temp = temp + newY(k)
      count = count + 1
     endif
  endfor
  newY(j) = round(temp/count);
  temp = 0;
  count = 0;
end
end

#plotting
plot(x, newY)
grid on
title('Smoother')

#reshape + writing
r = reshape([x;newY],31,2)
csvwrite('Smoother.csv',r)

