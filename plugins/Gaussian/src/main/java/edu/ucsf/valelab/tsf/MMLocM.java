// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MMLocM.proto

package edu.ucsf.valelab.tsf;

public final class MMLocM {
  private MMLocM() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registry.add(edu.ucsf.valelab.tsf.MMLocM.intensityAperture);
    registry.add(edu.ucsf.valelab.tsf.MMLocM.intensityBackground);
    registry.add(edu.ucsf.valelab.tsf.MMLocM.intensityRatio);
    registry.add(edu.ucsf.valelab.tsf.MMLocM.mSigma);
    registry.add(edu.ucsf.valelab.tsf.MMLocM.integralApertureSigma);
  }
  public static final int INTENSITY_APERTURE_FIELD_NUMBER = 1500;
  /**
   * <code>extend .TSF.Spot { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      edu.ucsf.valelab.tsf.TaggedSpotsProtos.Spot,
      java.lang.Float> intensityAperture = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.Float.class,
        null);
  public static final int INTENSITY_BACKGROUND_FIELD_NUMBER = 1501;
  /**
   * <code>extend .TSF.Spot { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      edu.ucsf.valelab.tsf.TaggedSpotsProtos.Spot,
      java.lang.Float> intensityBackground = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.Float.class,
        null);
  public static final int INTENSITY_RATIO_FIELD_NUMBER = 1502;
  /**
   * <code>extend .TSF.Spot { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      edu.ucsf.valelab.tsf.TaggedSpotsProtos.Spot,
      java.lang.Float> intensityRatio = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.Float.class,
        null);
  public static final int M_SIGMA_FIELD_NUMBER = 1503;
  /**
   * <code>extend .TSF.Spot { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      edu.ucsf.valelab.tsf.TaggedSpotsProtos.Spot,
      java.lang.Float> mSigma = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.Float.class,
        null);
  public static final int INTEGRAL_APERTURE_SIGMA_FIELD_NUMBER = 1504;
  /**
   * <code>extend .TSF.Spot { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      edu.ucsf.valelab.tsf.TaggedSpotsProtos.Spot,
      java.lang.Float> integralApertureSigma = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.Float.class,
        null);

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014MMLocM.proto\032\016TSFProto.proto:&\n\022intens" +
      "ity_aperture\022\t.TSF.Spot\030\334\013 \001(\002:(\n\024intens" +
      "ity_background\022\t.TSF.Spot\030\335\013 \001(\002:#\n\017inte" +
      "nsity_ratio\022\t.TSF.Spot\030\336\013 \001(\002:\033\n\007m_sigma" +
      "\022\t.TSF.Spot\030\337\013 \001(\002:+\n\027integral_aperture_" +
      "sigma\022\t.TSF.Spot\030\340\013 \001(\002B\026\n\024edu.ucsf.vale" +
      "lab.tsf"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          intensityAperture.internalInit(descriptor.getExtensions().get(0));
          intensityBackground.internalInit(descriptor.getExtensions().get(1));
          intensityRatio.internalInit(descriptor.getExtensions().get(2));
          mSigma.internalInit(descriptor.getExtensions().get(3));
          integralApertureSigma.internalInit(descriptor.getExtensions().get(4));
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          edu.ucsf.valelab.tsf.TaggedSpotsProtos.getDescriptor(),
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}