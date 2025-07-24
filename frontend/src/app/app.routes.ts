import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '', loadComponent: () => import('./content/content.component').then(m => m.ContentComponent)
    },
    {
        path: 'apply', loadComponent: () => import('./apply-form/apply-form.component').then(m => m.ApplyFormComponent)
    },
    {
        path: 'training', loadComponent: () => import('./digital-training/digital-training.component').then(m => m.DigitalTrainingComponent)
    },
    {
       path: 'signup', loadComponent: () => import('./signup/signup.component').then(m => m.SignupComponent) 
    },
    {
       path: 'signin', loadComponent: () => import('./signin/signin.component').then(m => m.SigninComponent) 
    }
];
