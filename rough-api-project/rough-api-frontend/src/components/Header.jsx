import React from 'react'
import SettingsIcon from '@mui/icons-material/Settings';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import GitHubIcon from '@mui/icons-material/GitHub';
import { IconButton } from '@mui/material';

function Header() {
  return (
    <div className='header'>
        <p>User-Management-System</p>      
        <div className='headerIcons'>
            <IconButton><AddCircleOutlineIcon /></IconButton>
            <IconButton><GitHubIcon /></IconButton>
            <IconButton><SettingsIcon /></IconButton>
        </div>
    </div>
  )
}

export default Header
