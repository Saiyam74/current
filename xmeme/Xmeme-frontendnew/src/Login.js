import React from 'react';
import {ReactComponent as logo} from './logo.jpg';
import './Login.css';
import {Link,Redirect} from 'react-router-dom' ;
import Axios from 'axios'; 


class Login extends React.Component{
    constructor(props){
        super(props);
        this.state={
            email:'',
            pwd:'',
            isloggedin: false,
            errors: null,
            nexturl:'/Feed'
    
        }
        this.onChange1=this.onChange1.bind(this);
        this.onChange2=this.onChange2.bind(this);
        this.handleSubmit=this.handleSubmit.bind(this);
    }

    
    
    handleSubmit(e){
        e.preventDefault();
        const user = {
            username:this.state.email,
            password:this.state.pwd
        }
        // console.log(user);
        Axios.post("http://localhost:8081/login",user).then(res=>{
            console.log(res.data);
             if(res.data==="User Logged in"){
                 this.setState({
                     isloggedin:true
                 })
             }
             else{
                 this.setState({
                     errors:"Login Failed"
                 })
             }
        })
    }
    onChange1(e){
        this.setState({email:e.target.value})
    }
    onChange2(e){
        this.setState({pwd:e.target.value})
    }
    render(){
        if(this.state.isloggedin){

            return <Redirect to ={{pathname:this.state.nexturl}}/>
        }
        else{

        
            return(
                <div className='div-login'>
                    
                    <div>
                            <div className='heading'>
                                <h1>LogIn</h1>
                            </div>
                        <form >
                            
                            <input type='email' name='email' placeholder='Enter your Email-id' required onChange={this.onChange1}  />
                            <input type='password' name='pwd' placeholder='Enter your Password' required onChange={this.onChange2} />
                            {this.state.errors}
                            <button className="btn1" onClick={this.handleSubmit}>Log In</button>
                            
                            <Link to = '/signup'><button className="btn2">Sign Up</button></Link>
                            
                        </form>
                    </div>
                </div>
            );
        }
    }
    
}

export default Login;