impl Solution {
    pub fn has_groups_size_x(deck: Vec<i32>) -> bool {
        
        let mut deck = deck;
        deck.sort();
        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        let mut pre = deck[0];
        let mut flag = false;
        while j < deck.len() {
            if deck[j] == pre {
                count += 1;
                j += 1;
            } else {
                if count == 1 {
                    return false;
                }
                if !flag {
                    i = count;
                    flag = true;
                } else {
                    i = gcd(i, count);
                    if i == 1 {
                        return false;
                    }
                }
                count = 1;
                pre = deck[j];
                j += 1;
            }
        }
        if count == 1 {
            return false;
        }
        if !flag {
            i = count;
            flag = true;
        } else {
            i = gcd(i, count);
            if i == 1 {
                return false;
            }
        }
        return true;
    }
}