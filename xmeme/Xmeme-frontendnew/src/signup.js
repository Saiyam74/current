import React from 'react';
import {ReactComponent as logo} from './logo.jpg'
import './Login.css'
import {Redirect} from 'react-router-dom' ;
import Axios from 'axios'; 
class Login extends React.Component{
    constructor(props){
        super(props);
        this.state={
            name:'',
            email:'',
            pwd:'',
            rpwd:'',
            isloggedin: false,
            errors: null,
            nexturl:'/login'
    
        }
        this.onChange1=this.onChange1.bind(this);
        this.onChange2=this.onChange2.bind(this);
        this.onChange0=this.onChange0.bind(this);
        this.onChange3=this.onChange3.bind(this);
        this.handleSubmit=this.handleSubmit.bind(this);
    }
    
    handleSubmit(e){
        e.preventDefault();
        const user = {

            username:this.state.email,
            password:this.state.pwd,
            fullname:this.state.name,
            email:this.state.email

        }
        // console.log(user);
        Axios.post("http://localhost:8082/signup",user).then(res=>{
            console.log(res.data);
             if(res.data==="data saved"){
                 this.setState({
                     isloggedin:true
                 })
             }
           
             
        })
    }
    onChange0(e){
        this.setState({name:e.target.value})
    }
    onChange1(e){
        this.setState({email:e.target.value})
    }
    onChange2(e){
        this.setState({pwd:e.target.value})
    }
    onChange3(e){
        var rpwd=e.target.value;
        if(rpwd===this.state.pwd){
            this.setState({
                errors:null
            })
        }
        else{
            this.setState({
                errors:"Password Mismatch"
            })
        }
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
                                <h1>Sign-up</h1>
                            </div>
                        <form >
                            <input type='text' name='name' placeholder='Enter your Full-Name' required onChange={this.onChange0}  />
                            <input type='email' name='email' placeholder='Enter your Email-id' required onChange={this.onChange1}  />
                            <input type='password' name='pwd' placeholder='Enter your Password' required onChange={this.onChange2} />
                            <input type='password' name='pwd' placeholder='Re-enter your Password' required onChange={this.onChange3} />
                            {this.state.errors}
                            <button className="btn2" onClick={this.handleSubmit}>Sign Up</button> 
                        </form>
                    </div>
                </div>
            )
        }
    }
}

export default Login;