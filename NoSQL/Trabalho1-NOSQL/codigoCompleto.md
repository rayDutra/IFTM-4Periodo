// Comandos no Mongo Shell
use ToDoListDB
db.createCollection("projects", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["name", "startDate", "endDate", "tasks"],
      properties: {
        name: {
          bsonType: "string"
        },
        startDate: {
          bsonType: "string"
        },
        endDate: {
          bsonType: "string"
        },
        tasks: {
          bsonType: "array",
          items: {
            bsonType: "object",
            required: ["title", "description", "creationDate", "status", "user"],
            properties: {
              title: {
                bsonType: "string"
              },
              description: {
                bsonType: "string"
              },
              creationDate: {
                bsonType: "string"
              },
              completionDate: {
                bsonType: "string"
              },
              status: {
                enum: ["To-Do", "In-Progress", "Done"]
              },
              user: {
                bsonType: "object",
                required: ["name", "email"],
                properties: {
                  name: {
                    bsonType: "string"
                  },
                  email: {
                    bsonType: "string",
                    pattern: "^\\S+@\\S+\\.\\S+$"
                  }
                }
              }
            }
          }
        }
      }
    }
  }
})

db.projects.insertMany([
  {
    name: "Project 3",
    startDate: "10/22/2023",
    endDate: "10/27/2023",
    tasks: [
      {
        title: "Task 1",
        description: "Description of Task 1 for Project 3",
        creationDate: "10/22/2023",
        status: "In-Progress",
        user: {
          name: "Bob Johnson",
          email: "bobjohnson@example.com"
        }
      }
    ]
  },
  {
    name: "Project 4",
    startDate: "10/23/2023",
    endDate: "10/28/2023",
    tasks: [
      {
        title: "Task 1",
        description: "Description of Task 1 for Project 4",
        creationDate: "10/23/2023",
        status: "To-Do",
        user: {
          name: "Eva Smith",
          email: "evasmith@example.com"
        }
      }
    ]
  },
  {
    name: "Project 5",
    startDate: "10/24/2023",
    endDate: "10/29/2023",
    tasks: [
      {
        title: "Task 1",
        description: "Description of Task 1 for Project 5",
        creationDate: "10/24/2023",
        status: "Done",
        user: {
          name: "Charlie Brown",
          email: "charliebrown@example.com"
        }
      }
    ]
  },
  {
    name: "Project 6",
    startDate: "10/25/2023",
    endDate: "10/30/2023",
    tasks: [
      {
        title: "Task 1",
        description: "Description of Task 1 for Project 6",
        creationDate: "10/25/2023",
        status: "In-Progress",
        user: {
          name: "Diana Johnson",
          email: "dianajohnson@example.com"
        }
      }
    ]
  },
  {
    name: "Project 7",
    startDate: "10/26/2023",
    endDate: "10/31/2023",
    tasks: [
      {
        title: "Task 1",
        description: "Description of Task 1 for Project 7",
        creationDate: "10/26/2023",
        status: "To-Do",
        user: {
          name: "Frank Smith",
          email: "franksmith@example.com"
        }
      }
    ]
  },
  {
    name: "Project 8",
    startDate: "10/27/2023",
    endDate: "11/1/2023",
    tasks: [
      {
        title: "Task 1",
        description: "Description of Task 1 for Project 8",
        creationDate: "10/27/2023",
        status: "Done",
        user: {
          name: "Grace Brown",
          email: "gracebrown@example.com"
        }
      }
    ]
  },
  {
    name: "Project 9",
    startDate: "10/28/2023",
    endDate: "11/2/2023",
    tasks: [
      {
        title: "Task 1",
        description: "Description of Task 1 for Project 9",
        creationDate: "10/28/2023",
        status: "In-Progress",
        user: {
          name: "Harry Johnson",
          email: "harryjohnson@example.com"
        }
      }
    ]
  },
  {
    name: "Project 10",
    startDate: "10/29/2023",
    endDate: "11/3/2023",
    tasks: [
      {
        title: "Task 1",
        description: "Description of Task 1 for Project 10",
        creationDate: "10/29/2023",
        status: "To-Do",
        user: {
          name: "Isabel Smith",
          email: "isabelsmith@example.com"
        }
      }
    ]
  }
]);

///////////////////////

//Passo 4: Operações de CRUD

//1-Buscar todos os projetos:
db.projects.find({})


//2-Buscar todos os projetos com uma tarefa "To-Do":
db.projects.find({"tasks.status": "To-Do"})

//3-Buscar todas as tarefas de um projeto específico:
db.projects.findOne({"name": "Project A"}).tasks

//4-Buscar todas as tarefas de um usuário específico:
db.projects.find({"tasks.user.email": "johndoe@example.com"})


//5-Buscar projetos que ainda têm tarefas concluídas:
db.projects.find({"tasks.status": {"$ne": "To-Do"}})

//6-Buscar projetos que ainda têm tarefas não concluídas:
db.projects.find({"tasks.status": "To-Do"})


//7-Todas as tarefas de um projeto que estejam com status "To-Do":
db.projects.findOne({ "name": "Project A", "tasks.status": "To-Do" }).tasks;


//8-Mudar o status de "In Progress" para "Complete" para uma tarefa específica:
db.projects.updateOne(
  { "tasks.title": "Task 2", "tasks.status": "In-Progress" },
  { "$set": { "tasks.$.status": "Complete" }}
);

//9-Todas as tarefas em andamento (status "In-Progress"):
db.projects.findOne({ "tasks.status": "In-Progress" }).tasks;

//10-Buscar todos os projetos concluídos:
db.projects.find({"tasks.status": "Done"});



//11-Buscar todas as tarefas de um projeto específico que estão concluídas:
db.projects.findOne({"name": "Project A", "tasks.status": "Done"}).tasks;

//12-Atualizar o status de uma tarefa específica para "Done":
db.projects.updateOne(
  { "tasks.title": "Task 1" },
  { "$set": { "tasks.$.status": "Done" }}
);

//13-Remover uma tarefa específica de um projeto (por exemplo, "Task 2" do "Project A"):
db.projects.updateOne(
  { "name": "Project A" },
  { "$pull": { "tasks": { "title": "Task 2" }}}
);
//14-Contar o número de projetos com pelo menos uma tarefa concluída:
db.projects.count({"tasks.status": "Done"});

//15-Buscar todos os projetos com uma tarefa concluída criada por um usuário específico (por exemplo, "janesmith@example.com"):
db.projects.find({"tasks.user.email": "janesmith@example.com", "tasks.status": "Done"});


////////////////////////////////////////////

//Passo 5:Operações de Update

//1-Alterar o usuário responsável por uma tarefa específica:
db.projects.updateOne(
  { "tasks.title": "Task 1" },
  { "$set": { "tasks.$.user.name": "Novo Nome", "tasks.$.user.email": "novonome@example.com" }}
);

//2-Dilatar o prazo de entrega de uma tarefa específica:
db.projects.updateOne(
  { "tasks.title": "Task 1" },
  { "$set": { "tasks.$.endDate": "11/05/2023" }}
);

//3- Mudar o status de "In Progress" para "Complete" para uma tarefa específica:
db.projects.updateOne(
  { "tasks.title": "Task 2", "tasks.status": "In-Progress" },
  { "$set": { "tasks.$.status": "Complete" }}
);

//4-Adicionar uma nova sub-tarefa a uma tarefa existente:
db.projects.updateOne(
  { "tasks.title": "Task 3" },
  {
    "$push": {
      "tasks.$.subtasks": {
        "title": "Subtask 1",
        "description": "Descrição da Subtarefa 1",
        "creationDate": "10/25/2023",
        "status": "To-Do"
      }
    }
  }
);


//5-Modificar a descrição de uma tarefa específica:
db.projects.updateOne(
  { "tasks.title": "Task 1" },
  { "$set": { "tasks.$.description": "Nova descrição da tarefa 1" }}
);

////////////////////////////////////////////

//Passo 6:Indexação e Otimização

db.projects.createIndex({"tasks.creationDate": 1});

db.projects.createIndex({"tasks.status": 1});

// Consulta antes da indexação
db.projects.find({"tasks.status": "To-Do"}).explain("executionStats");

// Consulta após a indexação
db.projects.find({"tasks.status": "To-Do"}).explain("executionStats");
