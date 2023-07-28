impl Solution {
    pub fn max_total_fruits(fruits: Vec<Vec<i32>>, start_pos: i32, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut pos = start_pos;
        let mut k = k;
        let mut i = 0;
        let mut j = fruits.len() - 1;
        let mut basket = vec![];
        while i <= j {
            let (left, right) = (fruits[i][0], fruits[j][0]);
            if left <= pos && right >= pos {
                if left == right {
                    let mut temp = 0;
                    for i in i..=j {
                        temp += fruits[i][1];
                    }
                    ans = ans.max(temp);
                    break;
                }
                let mut temp = 0;
                let mut flag = false;
                for i in i..=j {
                    if fruits[i][0] == left {
                        temp += fruits[i][1];
                    } else if fruits[i][0] == right {
                        if !flag {
                            temp += fruits[i][1];
                            flag = true;
                        } else {
                            break;
                        }
                    }
                }
                ans = ans.max(temp);
                if left < pos {
                    i += 1;
                }
                if right > pos {
                    j -= 1;
                }
            } else if left > pos {
                if k > 0 {
                    let mut temp = 0;
                    let mut flag = false;
                    for i in i..=j {
                        if fruits[i][0] == left {
                            temp += fruits[i][1];
                        } else if fruits[i][0] == right {
                            if !flag {
                                temp += fruits[i][1];
                                flag = true;
                            } else {
                                break;
                            }
                        }
                    }
                    ans = ans.max(temp);
                    if left < pos {
                        i += 1;
                    }
                    if right > pos {
                        j -= 1;
                    }
                    k -= 1;
                } else {
                    break;
                }
            } else if right < pos {
                if k > 0 {
                    let mut temp = 0;
                    let mut flag = false;
                    for i in i..=j {
                        if fruits[i][0] == left {
                            temp += fruits[i][1];
                        } else if fruits[i][0] == right {
                            if !flag {
                                temp += fruits[i][1];
                                flag = true;
                            } else {
                                break;
                            }
    }
}