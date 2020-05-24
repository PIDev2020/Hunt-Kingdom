<?php

namespace HuntKingdomBundle\Controller;

use HuntKingdomBundle\Entity\Commande;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;


class CommandeController extends Controller
{
    public function showCommandeAction()
    {
        $cm = new Commande();
        $em= $this->getDoctrine()->getManager();
        $state = $cm->getState();
        $commande =$em->getRepository('HuntKingdomBundle:Commande')->findByState($state=1);
        return $this->render('@HuntKingdom/Commande/ShowCommande.html.twig',array(
            'commande'=> $commande));
    }

    public function showCommandeUserAction()
    {
        $cm = new Commande();
        $em= $this->getDoctrine()->getManager();
        $state = $cm->getState();
        $commande =$em->getRepository('HuntKingdomBundle:Commande')->findByState($state=0);
        return $this->render('@HuntKingdom/Commande/ShowCommandeUser.html.twig',array(
            'commande'=> $commande));
    }
}
