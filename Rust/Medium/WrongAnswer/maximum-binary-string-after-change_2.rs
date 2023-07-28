impl Solution {
    pub fn maximum_binary_string(binary: String) -> String {
        
        let mut ans = String::new();
        let mut cnt = 0;
        let mut flag = false;
        for c in binary.chars() {
            if c == '0' {
                if flag {
                    ans.push('1');
                } else {
                    ans.push('0');
                }
                cnt += 1;
            } else {
                if cnt > 0 {
                    ans.push('1');
                    cnt -= 1;
                } else {
                    ans.push('1');
                    flag = true;
                }
            }
        }
        while cnt > 0 {
            ans.push('1');
            cnt -= 1;
        }
        ans
    }
}