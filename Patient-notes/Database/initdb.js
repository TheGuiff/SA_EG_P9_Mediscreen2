var db = new Mongo().getDB("patientnotes")

db.createCollection("notes")

db.notes.insertMany([
    {
        patientId: '1',
        content: 'Le patient déclare qu\'il « se sent très bien »\n' +
            'Poids égal ou inférieur au poids recommandé\n'
    },
    {
        patientId: '1',
        content: 'Le patient déclare qu\'il se sent fatigué pendant la journée\n' +
            'Il se plaint également de douleurs musculaires\n' +
            'Tests de laboratoire indiquant une microalbumine élevée\n'
    },
    {
        patientId: '1',
        content: 'Le patient déclare qu\'il ne se sent pas si fatigué que ça\n' +
            'Fumeur, il a arrêté dans les 12 mois précédents\n' +
            'Tests de laboratoire indiquant que les anticorps sont élevés\n'
    },
    {
        patientId: '2',
        content: 'Le patient déclare qu\'il ressent beaucoup de stress au travail\n' +
            'Il se plaint également que son audition est anormale dernièrement\n'
    },
    {
        patientId: '2',
        content: 'Le patient déclare avoir fait une réaction aux médicaments au cours des 3 derniers mois\n' +
            'Il remarque également que son audition continue d\'être anormale\n'
    },
    {
        patientId: '2',
        content: 'Tests de laboratoire indiquant une microalbumine élevée'
    },
    {
        patientId: '2',
        content: 'Le patient déclare que tout semble aller bien\n' +
            'Le laboratoire rapporte que l\'hémoglobine A1C dépasse le niveau recommandé\n' +
            'Le patient déclare qu’il fume depuis longtemps\n'
    },
    {
        patientId: '3',
        content: 'Le patient déclare qu\'il fume depuis peu'
    },
    {
        patientId: '3',
        content: 'Tests de laboratoire indiquant une microalbumine élevée'
    },
    {
        patientId: '3',
        content: 'Le patient déclare qu\'il est fumeur et qu\'il a cessé de fumer l\'année dernière\n' +
            'Il se plaint également de crises d’apnée respiratoire anormales\n' +
            'Tests de laboratoire indiquant un taux de cholestérol LDL élevé\n'
    },
    {
        patientId: '3',
        content: 'Tests de laboratoire indiquant un taux de cholestérol LDL élevé'
    },
    {
        patientId: '4',
        content: 'Le patient déclare qu\'il lui est devenu difficile de monter les escaliers\n' +
            'Il se plaint également d’être essoufflé\n' +
            'Tests de laboratoire indiquant que les anticorps sont élevés\n' +
            'Réaction aux médicaments\n'
    },
    {
        patientId: '4',
        content: 'Le patient déclare qu\'il a mal au dos lorsqu\'il reste assis pendant longtemps'
    },
    {
        patientId: '4',
        content: 'Le patient déclare avoir commencé à fumer depuis peu\n' +
            'Hémoglobine A1C supérieure au niveau recommandé\n'
    },
    {
        patientId: '5',
        content: 'Le patient déclare avoir des douleurs au cou occasionnellement\n' +
            'Le patient remarque également que certains aliments ont un goût différent\n' +
            'Réaction apparente aux médicaments\n' +
            'Poids corporel supérieur au poids recommandé\n'
    },
    {
        patientId: '5',
        content: 'Le patient déclare avoir eu plusieurs épisodes de vertige depuis la dernière visite.\n' +
            'Taille incluse dans la fourchette concernée\n'
    },
    {
        patientId: '5',
        content: 'Le patient déclare qu\'il souffre encore de douleurs cervicales occasionnelles\n' +
            'Tests de laboratoire indiquant une microalbumine élevée\n' +
            'Fumeur, il a arrêté dans les 12 mois précédents\n'
    },
    {
        patientId: '5',
        content: 'Le patient déclare avoir eu plusieurs épisodes de vertige depuis la dernière visite.\n' +
            'Tests de laboratoire indiquant que les anticorps sont élevés\n'
    },
    {
        patientId: '6',
        content: 'Le patient déclare qu\'il se sent bien\n' +
            'Poids corporel supérieur au poids recommandé\n'
    },
    {
        patientId: '6',
        content: 'Le patient déclare qu\'il se sent bien'
    },
    {
        patientId: '7',
        content: 'Le patient déclare qu\'il se réveille souvent avec une raideur articulaire\n' +
            'Il se plaint également de difficultés pour s’endormir\n' +
            'Poids corporel supérieur au poids recommandé\n' +
            'Tests de laboratoire indiquant un taux de cholestérol LDL élevé\n'
    },
    {
        patientId: '8',
        content: 'Les tests de laboratoire indiquent que les anticorps sont élevés\n' +
            'Hémoglobine A1C supérieure au niveau recommandé\n'
    },
    {
        patientId: '9',
        content: 'Le patient déclare avoir de la difficulté à se concentrer sur ses devoirs scolaires\n' +
            'Hémoglobine A1C supérieure au niveau recommandé\n'
    },
    {
        patientId: '9',
        content: 'Le patient déclare qu\'il s’impatiente facilement en cas d’attente prolongée\n' +
            'Il signale également que les produits du distributeur automatique ne sont pas bons\n' +
            'Tests de laboratoire signalant des taux anormaux de cellules sanguines\n'
    },
    {
        patientId: '9',
        content: 'Le patient signale qu\'il est facilement irrité par des broutilles\n' +
            'Il déclare également que l\'aspirateur des voisins fait trop de bruit\n' +
            'Tests de laboratoire indiquant que les anticorps sont élevés\n'
    },
    {
        patientId: '10',
        content: 'Le patient déclare qu\'il n\'a aucun problème'
    },
    {
        patientId: '10',
        content: 'Le patient déclare qu\'il n\'a aucun problème\n' +
            'Taille incluse dans la fourchette concernée\n' +
            'Hémoglobine A1C supérieure au niveau recommandé\n'
    },
    {
        patientId: '10',
        content: 'Le patient déclare qu\'il n\'a aucun problème\n' +
            'Poids corporel supérieur au poids recommandé\n' +
            'Le patient a signalé plusieurs épisodes de vertige depuis sa dernière visite\n'
    },
    {
        patientId: '10',
        content: 'Le patient déclare qu\'il n\'a aucun problème\n' +
            'Tests de laboratoire indiquant une microalbumine élevée\n'
    },

])