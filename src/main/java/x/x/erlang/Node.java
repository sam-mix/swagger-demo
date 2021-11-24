package x.x.erlang;



import com.ericsson.otp.erlang.*;

import java.io.IOException;

/**
 * 测试
 *
 * 120.79.199.40
 * 6bc1t325xjo21c1
 *
 */
public class Node {
    public static void main(String[] args) {

        String cookie = "123";


        OtpConnection connection = null;
        try {
            OtpSelf self = new OtpSelf("java_node@127.0.0.1", cookie);
            OtpPeer other = new OtpPeer("erl-node@127.0.0.1");
            connection = self.connect(other);

            if (connection.isConnected()) {
                OtpErlangList otpErlangObjects = new OtpErlangList(
                        new OtpErlangAtom("exports")
                );
                // 关闭节点 以下为启动节点的命令
                // werl -name erl-node@127.0.0.1 -setcookie 123
                connection.sendRPC("erlang", "module_info", otpErlangObjects);
                OtpErlangObject result = connection.receiveRPC();
                System.out.println(result);


                OtpErlangList otpErlangObjects1 = new OtpErlangList();
                connection.sendRPC("erlang", "module_info", otpErlangObjects1);
                OtpErlangObject result1 = connection.receiveRPC();
                System.out.println(result1);
            } else {
                System.out.println("connect fail");
            }
        } catch (IOException | OtpErlangExit | OtpAuthException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
    }
}
