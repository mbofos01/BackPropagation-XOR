import matplotlib.pyplot as plt
import sys

values_array_1 = []
values_array_2 = []

f=open(sys.argv[1],"r")
for line in f:
    values_array_1.append(float(line.strip('\n')))
print(values_array_1)

f=open(sys.argv[2],"r")
for line in f:
    values_array_2.append(float(line.strip('\n')))
print(values_array_2)

x = len(values_array_1)
counter_array_1 = [x]

for i in range(x-1):
   counter_array_1.insert(i,i+1) 

x = len(values_array_2)
counter_array_2 = [x]

for i in range(x-1):
   counter_array_2.insert(i,i+1) 



x_max = max(counter_array_1)  + 0.2*max(counter_array_1)
y_max = max(values_array_1) + 0.2*max(values_array_1)

fig = plt.figure()
plt.Axes.set_frame_on
plt.title("Error - Epoch")
plt.plot(counter_array_1,values_array_1, color = 'green')
plt.plot(counter_array_2, values_array_2, color = 'purple' )

plt.ylabel('error')
plt.xlabel('epoch')
plt.grid(True)
plt.xlim([0, x_max])
plt.ylim([0, y_max])
plt.legend(["Train Data", "Test Data"], loc='best')
plt.show()