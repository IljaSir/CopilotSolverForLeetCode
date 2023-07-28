impl Solution {
    pub fn strong_password_checker_ii(password: String) -> bool {
        
        let mut cnt = 0;
        if !password.chars().any(|c| c.is_ascii_lowercase()) {
            cnt += 1;
        }
        if !password.chars().any(|c| c.is_ascii_uppercase()) {
            cnt += 1;
        }
        if !password.chars().any(|c| c.is_ascii_digit()) {
            cnt += 1;
        }
        if !password.chars().any(|c| {
            "!@#$%^&*()-+".contains(c)
        }) {
            cnt += 1;
        }
        let mut chs = vec![];
        for c in password.chars() {
            if chs.last().map_or(false, |&ch| ch == c) {
                chs.last_mut().unwrap().1 += 1;
            } else {
                chs.push((c, 1));
            }
        }
        let mut del = 0;
        let mut rep = 0;
        for (_, cnt) in chs {
            if cnt >= 3 {
                del += cnt / 3;
                if cnt % 3 == 0 {
                    rep += 1;
                }
            }
        }
        if password.len() < 6 {
            cnt = cnt.max(6 - password.len());
        } else if password.len() > 20 {
            let del = password.len() - 20;
            if del <= del {
                cnt = cnt.max(del);
            } else {
                cnt = cnt.max(del - rep);
            }
        }
        cnt == 0
    }
}