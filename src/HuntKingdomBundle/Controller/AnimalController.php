<?php

namespace HuntKingdomBundle\Controller;

use HuntKingdomBundle\Entity\Animal;
use HuntKingdomBundle\Entity\Season;
use HuntKingdomBundle\Form\AnimalType;
use HuntKingdomBundle\HuntKingdomBundle;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class AnimalController extends Controller
{
    public function ajoutAnimalAction(Request $request)
    {
        $animal = new Animal();
        $form = $this->createForm(AnimalType::class,$animal);
        $form -> handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $saison = $animal->getSaison();
            $em = $this->getDoctrine()->getManager();
            $array_saison = $em->getRepository(Season::class)->findByNom($saison);
            if($array_saison!=null)
            {
                $S = $array_saison[0];
                $animal->setSeason($S);
                $em->persist($animal);
                $em->flush();
                $this->addFlash('info', 'Created Successfully !');
                return $this->redirectToRoute('hunt_kingdom_showAnimal');
            }else
            {
                return new Response("No Season like this");
            }


        }

        return $this->render("@HuntKingdom/Animal/ajoutAnimal.html.Twig",array("form"=>$form->createView()));
    }
    public function updateAnimalAction($id , Request $request){

        $em = $this->getDoctrine()->getManager();
        $animal = $em->getRepository(Animal::class)->find($id);
        $form = $this->createForm(AnimalType::class, $animal);
        $form = $form->handleRequest($request);
        if ($form->isSubmitted()){
            $em=$this->getDoctrine()->getManager();
            $em->persist($animal);
            $em->flush();
            return $this->redirectToRoute("hunt_kingdom_showAnimal");
        }
        return $this->render('@HuntKingdom/Animal/updateAnimal.html.twig',array('form'=>$form->createView()));
    }
    public function deleteAnimalAction($id)
    {
        $em=$this->getDoctrine()->getManager();
        $animal=$em->getRepository(Animal::class)->find($id);
        $em->remove($animal);
        $em->flush();
        return $this->redirectToRoute("hunt_kingdom_showAnimal");
    }


    public function showAnimalAction()
    {
        $em= $this->getDoctrine()->getManager();
        $animal =$em->getRepository('HuntKingdomBundle:Animal')->findAll();
        return $this->render('@HuntKingdom/Animal/showAnimal.html.twig',array(
            'animal'=> $animal));
    }
}
