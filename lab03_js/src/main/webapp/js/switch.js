/**
 * switch.html에 포함.
 */

// console.log('test');

const weekday = document.getElementById('weekday');
const btn = document.getElementById('btn');
const result = document.getElementById('result');

function selectListener() {
    const value = weekday.value;
    switch (value) {
        case 'mon':
        case 'tue':
        case 'wed':
        case 'thu':
        case 'fri':
            result.innerHTML = '학원 출석.';
            break;
        case 'sat':
        case 'sun':
            result.innerHTML = '놀러감.';
            break;
        default:
            result.innerHTML = '몰라요~';
    }
}

btn.addEventListener('click', selectListener);
