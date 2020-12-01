import screenshot from 'detox-take-screenshot';
import jestExpect from 'expect';
import {setupJestScreenshot} from 'jest-screenshot';

const {device, expect, element, by, waitFor} = require('detox');

global.device = device;
global.element = element;
global.by = by;
global.waitFor = waitFor;

describe('Example', () => {
  beforeEach(async () => {
    setupJestScreenshot();
    await device.reloadReactNative();
  });

  it('should have example screen', async () => {
    await expect(element(by.id('example_error'))).toBeVisible();
  });

  it('should have numberpicker', async () => {
    await waitFor(element(by.id('example')))
      .toBeVisible()
      .withTimeout(2000);

    jestExpect(await screenshot()).toMatchImageSnapshot();
  });
});
