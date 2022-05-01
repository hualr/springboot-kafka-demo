package com.cheng.kafka.com.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Function: <br>
 * Creating Time: 2022/5/1 <br>
 * Version: 1.0.0
 *
 * @author 宗旗
 */
@Data
@Accessors(chain = true)
public class MessageDTO {
    private String topicName;
    private String message;
    private Integer handleId;

}
