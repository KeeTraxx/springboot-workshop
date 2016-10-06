# springboot-workshop

## Step 1 - Create a new openshift project

    oc new-project kt-springboot
    
## Step 2 - Create a new app

    oc new-app --strategy=docker https://github.com/KeeTraxx/springboot-workshop.git
    
## Step 3 - Create a route for your app
 
    oc expose svc/springboot-workshop
    
    
### FAQ

#### How can I define a name for my app?
    oc new-app https://github.com/KeeTraxx/springboot-workshop.git --name="myapp"

#### How can I define another route?
    oc expose svc/springboot-workshop --hostname=springboot.mydomain.com
    
Note: You need to take care of DNS entries yourself!

