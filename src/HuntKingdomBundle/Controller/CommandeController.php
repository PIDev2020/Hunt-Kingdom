<?php

namespace HuntKingdomBundle\Controller;
use HuntKingdomBundle\Entity\Commande;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class CommandeController extends Controller
{
    public function showCommandeAction()
    {
        $em= $this->getDoctrine()->getManager();
        $commande =$em->getRepository('HuntKingdomBundle:Commande')->findAll();
        return $this->render('@HuntKingdom/Commande/showCommande.html.twig',array(
            'commande'=> $commande));
    }
}
