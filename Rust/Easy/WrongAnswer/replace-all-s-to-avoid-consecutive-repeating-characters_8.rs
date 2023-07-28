impl Solution {
    pub fn modify_string(s: String) -> String {
        
        let mut s = s.as_bytes().to_vec();
        let mut i = 0;
        while i < s.len() {
            if s[i] == b'?' {
                if i == 0 {
                    if i + 1 < s.len() {
                        if s[i + 1] == b'z' {
                            s[i] = b'a';
                        } else {
                            s[i] = s[i + 1] + 1;
                        }
                    } else {
                        s[i] = b'a';
                    }
                } else {
                    if i + 1 < s.len() {
                        if s[i - 1] == b'z' {
                            if s[i + 1] == b'z' {
                                s[i] = b'a';
                            } else {
                                s[i] = s[i + 1] + 1;
                            }
                        } else {
                            if s[i + 1] == b'z' {
                                s[i] = s[i - 1] + 1;
                            } else {
                                if s[i + 1] == s[i - 1] {
                                    s[i] = s[i - 1] + 1;
                                } else {
                                    if s[i + 1] == s[i - 1] + 1 {
                                        s[i] = s[i - 1] + 2;
                                    } else {
                                        s[i] = s[i - 1] + 1;
                                    }
                                }
                            }
                        }
                    } else {
                        if s[i - 1] == b'z' {
                            s[i] = b'a';
                        } else {
                            s[i] = s[i - 1] + 1;
                        }
                    }
                }
            }
            i += 1;
        }
        String::from_utf8(s).unwrap()
    }
}