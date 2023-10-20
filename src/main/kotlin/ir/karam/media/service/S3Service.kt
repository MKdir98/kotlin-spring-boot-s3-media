package ir.karam.media.service

import com.amazonaws.AmazonServiceException
import com.amazonaws.SdkClientException
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.ObjectMetadata
import org.apache.commons.codec.binary.Base64
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.util.*


@Service
class S3Service {

    @Value("\${arvan.bucket}")
    lateinit var bucketName: String

    @Value("\${arvan.access-key}")
    lateinit var accessKey: String

    @Value("\${arvan.secret-key}")
    lateinit var secretKey: String

    @Value("\${arvan.url}")
    lateinit var url: String

    @Value("\${arvan.sign-region}")
    lateinit var signRegion: String

    fun saveFile(multipartFile: MultipartFile): String {
        val data = ObjectMetadata()
        val key = UUID.randomUUID().toString()
        data.contentType = multipartFile.contentType
        data.contentLength = multipartFile.size
        val s3Client = getS3Client()
        s3Client.putObject(bucketName, key, multipartFile.inputStream, data)
        return key
    }

    private fun getS3Client(): AmazonS3 {
        val credentials = BasicAWSCredentials(accessKey, secretKey)
        return AmazonS3ClientBuilder
            .standard()
            .withEndpointConfiguration(AwsClientBuilder.EndpointConfiguration(url, signRegion))
            .withCredentials(AWSStaticCredentialsProvider(credentials))
            .build()
    }
}