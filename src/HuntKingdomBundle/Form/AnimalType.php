<?php

namespace HuntKingdomBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Validator\Constraints\Choice;

class AnimalType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
         $builder->add('idA')
                 ->add('race')
                 ->add('saison',ChoiceType::class,array(
                     'choices'=>array(
                         'fall'=>'fall',
                         'summer'=>'summer',
                         'winter'=>'winter',
                         'spring'=>'spring',
                         'all'=>'all'
                     )
                 ))
                 ->add('place')
                 ->add('image')
                 ->add('hunted')
                 ->add('Add Animal',SubmitType::class);

    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'HuntKingdomBundle\Entity\Animal'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'huntkingdombundle_animal';
    }


}
