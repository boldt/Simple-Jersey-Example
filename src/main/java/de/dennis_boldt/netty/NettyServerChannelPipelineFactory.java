package de.dennis_boldt.netty;

import static org.jboss.netty.channel.Channels.pipeline;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.handler.codec.http.HttpChunkAggregator;
import org.jboss.netty.handler.codec.http.HttpRequestDecoder;
import org.jboss.netty.handler.codec.http.HttpResponseEncoder;

import com.devsprint.jersey.api.container.netty.JerseyHandler;

public class NettyServerChannelPipelineFactory implements
        ChannelPipelineFactory {

    private final transient JerseyHandler jerseyHandler;

    public NettyServerChannelPipelineFactory(final JerseyHandler jerseyHandler) {
        this.jerseyHandler = jerseyHandler;
    }

    /**
     * Retrieve the channel pipeline factory.
     *
     * @see org.jboss.netty.channel.ChannelPipelineFactory#getPipeline()
     */
    public ChannelPipeline getPipeline() {
        final ChannelPipeline pipeline = pipeline();
        pipeline.addLast("decoder", new HttpRequestDecoder());
        pipeline.addLast("aggregator", new HttpChunkAggregator(1024*1024*100));// 100 MB
        pipeline.addLast("encoder", new HttpResponseEncoder());
        pipeline.addLast("jerseyHandler", jerseyHandler);
        return pipeline;
    }

}