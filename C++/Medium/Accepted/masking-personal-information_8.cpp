class Solution {
public:
    string maskPII(string s) {
        
        string result;
        int pos = s.find('@');
        if (pos != string::npos) {
            result = s[0];
            result += "*****";
            result += s[pos-1];
            result += s.substr(pos);
            for (int i = 0; i < result.length(); i++) {
                if (result[i] >= 'A' && result[i] <= 'Z')
                    result[i] += 32;
            }
        } else {
            string phone;
            for (int i = 0; i < s.length(); i++) {
                if (s[i] >= '0' && s[i] <= '9')
                    phone += s[i];
            }
            if (phone.length() == 10) {
                result = "***-***-";
                result += phone.substr(6);
            } else {
                result = "+";
                for (int i = 0; i < phone.length()-10; i++)
                    result += '*';
                result += "-***-***-";
                result += phone.substr(phone.length()-4);
            }
        }
        return result;
    }
};