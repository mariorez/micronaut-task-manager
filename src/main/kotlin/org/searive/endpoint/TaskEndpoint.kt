package org.searive.endpoint

import org.seariver.proto.CreateTaskRequest
import org.seariver.proto.FindAllRequest
import org.seariver.proto.TaskAllResponse
import org.seariver.proto.TaskProto
import org.seariver.proto.TaskProto.Status.TODO
import org.seariver.proto.TaskServiceGrpcKt.TaskServiceCoroutineImplBase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class TaskEndpoint : TaskServiceCoroutineImplBase() {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(TaskEndpoint::class.java.name)
    }

    override suspend fun create(request: CreateTaskRequest): TaskProto {
        LOG.info("Start create task")
        return TaskProto.newBuilder().build();
    }

    override suspend fun findAll(request: FindAllRequest): TaskAllResponse {

        LOG.info("Start findAll")

        val allBuilder = TaskAllResponse.newBuilder()

        for (i in 1..10) {
            allBuilder.addTask(
                TaskProto
                    .newBuilder()
                    .setTitle("Task Manager $i")
                    .setStatus(TODO)
                    .build()
            )
        }

        return allBuilder.build()
    }
}