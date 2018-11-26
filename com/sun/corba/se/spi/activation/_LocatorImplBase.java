package com.sun.corba.se.spi.activation;


/**
* com/sun/corba/se/spi/activation/_LocatorImplBase.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /HUDSON/workspace/8-2-build-linux-amd64/jdk8u192/11895/corba/src/share/classes/com/sun/corba/se/spi/activation/activation.idl
* Saturday, October 6, 2018 6:46:21 AM PDT
*/

public abstract class _LocatorImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements com.sun.corba.se.spi.activation.Locator, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _LocatorImplBase ()
  {
  }

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("locateServer", new java.lang.Integer (0));
    _methods.put ("locateServerForORB", new java.lang.Integer (1));
    _methods.put ("getEndpoint", new java.lang.Integer (2));
    _methods.put ("getServerPortForType", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {

  // Starts the server if it is not already running.
       case 0:  // activation/Locator/locateServer
       {
         try {
           int serverId = com.sun.corba.se.spi.activation.ServerIdHelper.read (in);
           String endPoint = in.read_string ();
           com.sun.corba.se.spi.activation.LocatorPackage.ServerLocation $result = null;
           $result = this.locateServer (serverId, endPoint);
           out = $rh.createReply();
           com.sun.corba.se.spi.activation.LocatorPackage.ServerLocationHelper.write (out, $result);
         } catch (com.sun.corba.se.spi.activation.NoSuchEndPoint $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.spi.activation.NoSuchEndPointHelper.write (out, $ex);
         } catch (com.sun.corba.se.spi.activation.ServerNotRegistered $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.spi.activation.ServerNotRegisteredHelper.write (out, $ex);
         } catch (com.sun.corba.se.spi.activation.ServerHeldDown $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.spi.activation.ServerHeldDownHelper.write (out, $ex);
         }
         break;
       }


  // Starts the server if it is not already running.
       case 1:  // activation/Locator/locateServerForORB
       {
         try {
           int serverId = com.sun.corba.se.spi.activation.ServerIdHelper.read (in);
           String orbId = com.sun.corba.se.spi.activation.ORBidHelper.read (in);
           com.sun.corba.se.spi.activation.LocatorPackage.ServerLocationPerORB $result = null;
           $result = this.locateServerForORB (serverId, orbId);
           out = $rh.createReply();
           com.sun.corba.se.spi.activation.LocatorPackage.ServerLocationPerORBHelper.write (out, $result);
         } catch (com.sun.corba.se.spi.activation.InvalidORBid $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.spi.activation.InvalidORBidHelper.write (out, $ex);
         } catch (com.sun.corba.se.spi.activation.ServerNotRegistered $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.spi.activation.ServerNotRegisteredHelper.write (out, $ex);
         } catch (com.sun.corba.se.spi.activation.ServerHeldDown $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.spi.activation.ServerHeldDownHelper.write (out, $ex);
         }
         break;
       }


  // get the port for the endpoint of the locator
       case 2:  // activation/Locator/getEndpoint
       {
         try {
           String endPointType = in.read_string ();
           int $result = (int)0;
           $result = this.getEndpoint (endPointType);
           out = $rh.createReply();
           out.write_long ($result);
         } catch (com.sun.corba.se.spi.activation.NoSuchEndPoint $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.spi.activation.NoSuchEndPointHelper.write (out, $ex);
         }
         break;
       }


  // to pick a particular port type.
       case 3:  // activation/Locator/getServerPortForType
       {
         try {
           com.sun.corba.se.spi.activation.LocatorPackage.ServerLocationPerORB location = com.sun.corba.se.spi.activation.LocatorPackage.ServerLocationPerORBHelper.read (in);
           String endPointType = in.read_string ();
           int $result = (int)0;
           $result = this.getServerPortForType (location, endPointType);
           out = $rh.createReply();
           out.write_long ($result);
         } catch (com.sun.corba.se.spi.activation.NoSuchEndPoint $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.spi.activation.NoSuchEndPointHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:activation/Locator:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }


} // class _LocatorImplBase
