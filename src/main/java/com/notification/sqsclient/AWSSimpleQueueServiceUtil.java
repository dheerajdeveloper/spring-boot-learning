//package com.notification.sqsclient;
//
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.sqs.AmazonSQS;
//import com.amazonaws.services.sqs.AmazonSQSClient;
//import com.amazonaws.services.sqs.model.*;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.notification.json.OrderJson;
//import org.springframework.util.CollectionUtils;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.List;
//import java.util.Properties;
//
///**
// * Created by IntelliJ IDEA.
// * User: Niraj Singh
// * Date: 3/19/13
// * Time: 10:44 AM
// * To change this template use File | Settings | File Templates.
// */
//public class AWSSimpleQueueServiceUtil {
//    private BasicAWSCredentials credentials;
//    private AmazonSQS sqs;
//    private String simpleQueue = "PhotoQueue";
//    private static volatile AWSSimpleQueueServiceUtil awssqsUtil = new AWSSimpleQueueServiceUtil();
//
//    /**
//     * instantiates a AmazonSQSClient http://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/sqs/AmazonSQSClient.html
//     * Currently using  BasicAWSCredentials to pass on the credentials.
//     * For SQS you need to set your regions endpoint for sqs.
//     */
//    private AWSSimpleQueueServiceUtil() {
//        try {
//            Properties properties = new Properties();
//            properties.load(new FileInputStream("/Users/dheeraj/repo/notification-system/src/main/resources/AwsCredentials.properties"));
//            this.credentials = new BasicAWSCredentials(properties.getProperty("accessKey"),
//                    properties.getProperty("secretKey"));
//            this.simpleQueue = "cn_dheeraj";
//
//            this.sqs = new AmazonSQSClient(this.credentials);
//            /**
//             * My queue is in singapore region which has following endpoint for sqs
//             * https://sqs.ap-southeast-1.amazonaws.com
//             * you can find your endpoints here
//             * http://docs.aws.amazon.com/general/latest/gr/rande.html
//             *
//             * Overrides the default endpoint for this client ("sqs.us-east-1.amazonaws.com")
//             */
//            this.sqs.setEndpoint("sqs.us-east-1.amazonaws.com");
//            /*
//               You can use this in your web app where    AwsCredentials.properties is stored in web-inf/classes
//             */
//            //AmazonSQS sqs = new AmazonSQSClient(new ClasspathPropertiesFileCredentialsProvider());
//
//        } catch (Exception e) {
//            System.out.println("exception while creating awss3client : " + e);
//        }
//    }
//
//    public static AWSSimpleQueueServiceUtil getInstance() {
//        return awssqsUtil;
//    }
//
//    public AmazonSQS getAWSSQSClient() {
//        return awssqsUtil.sqs;
//    }
//
//    public String getQueueName() {
//        return awssqsUtil.simpleQueue;
//    }
//
//    /**
//     * Creates a queue in your region and returns the url of the queue
//     *
//     * @param queueName
//     * @return
//     */
//    public String createQueue(String queueName) {
//        CreateQueueRequest createQueueRequest = new CreateQueueRequest(queueName);
//        String queueUrl = this.sqs.createQueue(createQueueRequest).getQueueUrl();
//        return queueUrl;
//    }
//
//    /**
//     * returns the queueurl for for sqs queue if you pass in a name
//     *
//     * @param queueName
//     * @return
//     */
//    public String getQueueUrl(String queueName) {
//        GetQueueUrlRequest getQueueUrlRequest = new GetQueueUrlRequest(queueName);
//        return this.sqs.getQueueUrl(getQueueUrlRequest).getQueueUrl();
//    }
//
//    /**
//     * lists all your queue.
//     *
//     * @return
//     */
//    public ListQueuesResult listQueues() {
//        return this.sqs.listQueues();
//    }
//
//    /**
//     * send a single message to your sqs queue
//     *
//     * @param queueUrl
//     * @param message
//     */
//    public void sendMessageToQueue(String queueUrl, String message) {
//        SendMessageResult messageResult = this.sqs.sendMessage(new SendMessageRequest(queueUrl, message));
//        System.out.println(messageResult.toString());
//    }
//
//    /**
//     * gets messages from your queue
//     *
//     * @param queueUrl
//     * @return
//     */
//    public List<Message> getMessagesFromQueue(String queueUrl) {
//        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
//        List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
//        return messages;
//    }
//
//    /**
//     * deletes a single message from your queue.
//     *
//     * @param queueUrl
//     * @param message
//     */
//    public void deleteMessageFromQueue(String queueUrl, Message message) {
//        String messageRecieptHandle = message.getReceiptHandle();
//        System.out.println("message deleted : " + message.getBody() + "." + message.getReceiptHandle());
//        sqs.deleteMessage(new DeleteMessageRequest(queueUrl, messageRecieptHandle));
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        AWSSimpleQueueServiceUtil awsSimpleQueueServiceUtil = new AWSSimpleQueueServiceUtil();
//
//        List<Message> messages = awsSimpleQueueServiceUtil.getMessagesFromQueue("https://sqs.us-east-1.amazonaws.com/082830052325/cn_dheeraj");
//
//        if (CollectionUtils.isEmpty(messages)) {
//            return;
//        }
//        String jsonString = messages.get(0).getBody();
//        ObjectMapper mapper = new ObjectMapper();
//
//        OrderJson obj = mapper.readValue(jsonString, OrderJson.class);
//
//        System.out.println(jsonString);
//
//        awsSimpleQueueServiceUtil.methodPost(jsonString);
//
//
//    }
//
//    void methodPost(String jsonString) {
//        try {
//
//            URL url = new URL("http://localhost:8080/order/add");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setDoOutput(true);
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json");
//
//            String input = jsonString;
//
//            OutputStream os = conn.getOutputStream();
//            os.write(input.getBytes());
//            os.flush();
//
//            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    (conn.getInputStream())));
//
//            String output;
//            System.out.println("Output from Server .... \n");
//            while ((output = br.readLine()) != null) {
//                System.out.println(output);
//            }
//
//            conn.disconnect();
//
//        } catch (MalformedURLException e) {
//
//            e.printStackTrace();
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//
//        }
//    }
//
//}