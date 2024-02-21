#implementing batch gradient
from statistics import mean
def gradW1(x1,x2,y,w1,w2):
    w1_new= -2*(y-(w1*x1+w2*x2))*x1
    return(w1_new)
    
    

def gradW2(x1,x2,y,w1,w2):
    w2_new= -2*(y-(w1*x1+w2*x2))*x2 
    return(w2_new)

x1=[1,2,0,-2]
x2=[0,1,1,1]
y=[1,9,1,7]
w1=1
w2=3

learning_rate=0.01
for i in range(0,25):#no.of epochs-25
    arr_W1=[]
    arr_W2=[]
    for a,b,c in zip(x1,x2,y):
        w1_grad=gradW1(a,b,c,w1,w2)
        w2_grad=gradW2(a,b,c,w1,w2)
        arr_W1.append(w1_grad)
        arr_W2.append(w2_grad)




    w1=w1-learning_rate*(mean(arr_W1))
    w2=w2-learning_rate*(mean(arr_W2))

    
    print("Updated weights for batch gradient")
    print("W1 :",w1)
    print("W2 :",w2)   



