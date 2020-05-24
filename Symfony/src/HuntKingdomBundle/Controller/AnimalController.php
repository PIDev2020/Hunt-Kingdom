<?php

namespace HuntKingdomBundle\Controller;

use HuntKingdomBundle\Entity\Animal;
use HuntKingdomBundle\Entity\Season;
use HuntKingdomBundle\Form\AnimalType;
use HuntKingdomBundle\HuntKingdomBundle;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\SwiftmailerBundle\SwiftmailerBundle;

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
            $animal->setSeason($saison);

                $em->persist($animal);
                $em->flush();
                $this->addFlash('info', 'Created Successfully !');
                return $this->redirectToRoute('hunt_kingdom_showAnimal');



        }

        return $this->render("@HuntKingdom/Animal/ajoutAnimal.html.Twig",array("form"=>$form->createView()));
    }
    public function updateAnimalAction($id , Request $request){

        $em = $this->getDoctrine()->getManager();
        $animal = $em->getRepository(Animal::class)->find($id);
        $form = $this->createForm(AnimalType::class, $animal);
        $form = $form->handleRequest($request);
        $transport = \Swift_SmtpTransport::newInstance('smtp.gmail.com', 465,'ssl')
            ->setUsername('achrefshron96@gmail.com')->setPassword('achrefzeddini');

        $mailer = \Swift_Mailer::newInstance($transport);
        $message = \Swift_Message::newInstance('Test')
            ->setFrom(array('achrefshron96@gmail.com' => ''))
            ->setTo(array("achrefshron96@gmail.com" => "achrefshron96@gmai.com"))
            ->setBody("<h1>You made some changes</h1>", 'text/html');
        $mailer->send($message);
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
    public function frontAnimalAction()
    {
        $em= $this->getDoctrine()->getManager();
        $animal =$em->getRepository('HuntKingdomBundle:Animal')->findAll();
        return $this->render('@HuntKingdom/Animal/frontAnimal.html.twig',array(
            'animal'=> $animal));
    }
}
