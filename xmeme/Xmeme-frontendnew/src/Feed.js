import { Container } from '@material-ui/core';
import React from 'react';
import {Grid,Typography} from '@material-ui/core';
import { Link } from 'react-router-dom';
import Axios from 'axios';

class Feed extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            submitting:false,
            name:'',
            url:'',
            caption:'',
            tableData:[]
        }
        this.toggleSubmitting = this.toggleSubmitting.bind(this);
        this.onChange0 = this.onChange0.bind(this);
        this.onChange1 = this.onChange1.bind(this);
        this.onChange2 = this.onChange2.bind(this);
        this.submitMeme = this.submitMeme.bind(this);
    }

    submitMeme(e) {
        e.preventDefault();
        const meme = {
            name: this.state.name,
            url: this.state.url,
            caption: this.state.caption
        }
        Axios.post("http://localhost:8083/memes", meme).then(res=>{
            console.log(res.data);
            console.log(meme);
            this.toggleSubmitting();
        });
    }

    componentDidMount() {
        Axios.get("http://localhost:8083/memes").then(res=>{
            console.log(res.data);
            this.setState({
                tableData:res.data
            })
        })
    }

    renderTable() {
        return this.state.tableData.map((MemeList, index)=>{
            const {
                id,
                name,
                url,
                caption
            } = MemeList;
            var newurl='';
            var newcaption='';
            // console.log(MemeDTO);
            return(<Grid item xs={3} style={{backgroundColor: "#EDF7F6", borderRadius:10, margin:5}}>
            <Grid container style={{height:370}}>
                <Grid item xs={12} >
                    <Typography variant="h6" align="center">
                        Caption: {caption}
                    </Typography>
                </Grid>
                
                <Grid item xs={12} alignItems="center">
                <img class ='center' src={url} style={{maxWidth:300, maxHeight:150}} alt="meme not displayed">

                </img>
                </Grid>
               
                <Grid item xs={12}>
                    <Typography variant="h8" align="center" font-weight= 'bolder'>
                        Created By : {name}
                        <hr font-weight='bolder'></hr>
                    </Typography>
                    
                </Grid>
{/*                 
                <button className="btn1" 
                onClick={
                    (e)=>{
                        MemeDTO.open = !MemeDTO.open;
                        console.log(MemeDTO.open);
                    }
                }
                >Update</button> */}
                {/* {MemeDTO.open? */}
                <div>
                    <input  type='url' name='url' placeholder='Enter your url' required onChange={
                        (e)=>{
                            newurl=e.target.value;
                        }
                    } />
                    <input type='text' name='caption' placeholder='Enter your Caption' required onChange={
                        (e)=>{
                            newcaption=e.target.value;
                        }
                    } />
                    <button className="btn1" onClick={
                        (e)=>{
                            e.preventDefault();
                            const changebody={
                                url:newurl,
                                caption:newcaption
                            }
                            console.log("sending resquest");
                            console.log(changebody);
                            Axios.patch("http://localhost:8083/memes/"+id, changebody).then(res=>{
                                console.log(res);
                            });
                        }
                    }>Click her to Update</button>
                </div>
                {/* :<span></span>
                } */}
                
            </Grid>
        </Grid>);
        })
    }

    onChange0(e){
        this.setState({name:e.target.value})
    }
    onChange1(e){
        this.setState({url:e.target.value})
    }
    onChange2(e){
        this.setState({caption:e.target.value})
    }

    toggleSubmitting() {
        this.setState({
            submitting:!this.state.submitting
        });
    }
    
    render() { 
        return (
            
            <Container fixed style={{backgroundColor: "lightgrey", borderRadius:20, marginTop: 50,marginLeft: 125, padding:20, height:"100%"}}>
                <button className="btn1" onClick={this.toggleSubmitting}>Upload Your Meme</button>
                {this.state.submitting?
                    <div>
                        <input type='text' name='name' placeholder='Enter your Full Name' required onChange={this.onChange0}  />
                        <input type='url' name='url' placeholder='Enter your url' required onChange={this.onChange1} />
                        <input type='text' name='caption' placeholder='Enter your Caption' required onChange={this.onChange2} />
                        <button className="btn1" onClick={this.submitMeme}>Upload</button>    
                    </div>
                    :<span></span>
                }
                
                
   
                <Grid container spacing={2} style={{flexGrow:1, marginTop:15, marginBottom:15}} justify="space-evenly" spacing={2}>
                {this.renderTable()}
                    
                </Grid>
                
            </Container>
                
            
        );
    }
}
 
export default Feed;