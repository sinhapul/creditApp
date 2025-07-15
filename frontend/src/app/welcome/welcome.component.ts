import { Component } from '@angular/core';
import { HeroComponent } from '../home/components/hero/hero.component';
import { FooterComponent } from '../home/components/footer/footer.component';
import { BenefitsComponent } from '../home/components/benefits/benefits.component';
import { EligibilityComponent } from '../home/components/eligibility/eligibility.component';
import { FeaturesComponent } from '../home/components/features/features.component';
import { NavbarComponent } from '../home/components/navbar/navbar.component';

@Component({
  selector: 'app-welcome',
  standalone: true,
  imports : [HeroComponent, FooterComponent, BenefitsComponent, EligibilityComponent, FeaturesComponent, NavbarComponent],
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent {

}
